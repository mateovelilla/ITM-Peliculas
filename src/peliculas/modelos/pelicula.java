
package peliculas.modelos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import peliculas.dao.peliculaDAO;
import peliculas.dto.peliculaDTO;
public class pelicula {
    String _titulo,_nacion,_idioma,_color,_resumen,_observaciones,_error;
    int _ano,_id,_director;
    public String getError() {
        return this._error;
    }
    public pelicula(int id,int director,String titulo,String nacion,String idioma,String color,String resumen,String observaciones, int ano)
    {
        this._titulo = titulo;
        this._nacion = nacion;
        this._idioma = idioma;
        this._color = color;
        this._resumen = resumen;
        this._observaciones = observaciones;
        this._ano = ano;
        this._id = id;
        this._director = director;
    }
    private Boolean validarTitulo ()
    {
        boolean response = false;
        if(this._titulo.length() == 0 || this._titulo.isEmpty())
        {
            this._error = "El titulo es obligatorio";
            response = false;
        }else
        {
            response = true;
        }
        return response; 
    }
    private Boolean validarNacion()
    {
        boolean response = false;
        if(this._nacion.length() == 0 || this._nacion.isEmpty())
        {
            this._error = "La nación es obligatoria";
            response = false;
        }else
        {
            response = true;
        }
        return response;    
    }
    
    private Boolean validarIdioma()
    {
        boolean response = false;
        if(this._idioma.length() == 0 || this._idioma.isEmpty())
        {
            this._error = "El idioma es obligatorio";
            response = false;
        }else
        {
            response = true;
        }
        return response;    
    }
    
    private Boolean validarColor()
    {
        boolean response = false;
        if(this._color.length() == 0 || this._color.isEmpty())
        {
            this._error = "El color es obligatorio";
            response = false;
        }else
        {
            response = true;
        }
        return response;   
    }
    private Boolean validarResumen()
    {
        boolean response = false;
        if(this._resumen.length() == 0 || this._resumen.isEmpty())
        {
            this._error = "El resumen es obligatorio";
            response = false;
        }else
        {
            response = true;
        }
        return response;   
    }
    private Boolean validarObservaciones()
    {
        boolean response = false;
        if(this._observaciones.length() == 0 || this._observaciones.isEmpty())
        {
            this._error = "Las observaciones son obligatorias";
            response = false;
        }else
        {
            response = true;
        }
        return response; 
    }
    private Boolean validarAno()
    {
        boolean response = false;
        if(this._ano == 0)
        {
            response = false;
            this._error = "El año es obligatorio";
        }else{
            return true;
        }
        return response;
        
    }
    public Boolean Guardar()
    {
        boolean response = false;
        if(!this.validarTitulo())
            return false;
        if(!this.validarNacion())
            return false;
        if(!this.validarColor())
            return false;
        if(!this.validarIdioma())
            return false;
        if(!this.validarResumen())
            return false;
        if(!this.validarObservaciones())
            return false;
        if(!this.validarAno())
            return false;
        try{
            peliculaDTO pelicula = new peliculaDTO();
            peliculaDAO dao = new peliculaDAO();
            pelicula.setDirectorId(this._director);
            pelicula.setTitulo(this._titulo);
            pelicula.setAno(this._ano);
            pelicula.setNacion(this._nacion);
            pelicula.setIdioma(this._idioma);
            pelicula.setColor(this._color);
            pelicula.setResumen(this._resumen);
            pelicula.setObservacion(this._observaciones);
            response = dao.crear(pelicula);
        }catch(Exception e){
            System.err.println("Error");
            System.err.println(e);
        }
        return response;

    }
     public JSONArray consultar()
     {
               JSONArray peliculas = new JSONArray();
        try{
            peliculaDAO dao = new peliculaDAO();
            peliculaDTO dto = new peliculaDTO();
            dto.setTitulo(this._titulo.isEmpty()?"":this._titulo);  
            dto.setAno(this._ano == 0 ? 0:this._ano);  
            dto.setNacion(this._nacion.isEmpty()?"":this._nacion);  
            dto.setIdioma(this._idioma.isEmpty()?"":this._idioma);  
            dto.setColor(this._color.isEmpty()?"":this._color);  
            dto.setResumen(this._resumen.isEmpty()?"":this._resumen);  
            dto.setObservacion(this._observaciones.isEmpty()?"":this._observaciones);
            peliculaDTO[] peliculasDTO = dao.buscarPelicula(dto);
            for (int i = 0; i < peliculasDTO.length; i++) {
                JSONObject pelicula = new JSONObject();
                pelicula.put("id", peliculasDTO[i].getId());
                pelicula.put("directorID", peliculasDTO[i].getDirectorId());
                pelicula.put("titulo", peliculasDTO[i].getTitulo());
                pelicula.put("ano", peliculasDTO[i].getAno());
                pelicula.put("nacion", peliculasDTO[i].getNacion());
                pelicula.put("idioma", peliculasDTO[i].getIdioma());
                pelicula.put("color", peliculasDTO[i].getColor());
                pelicula.put("resumen", peliculasDTO[i].getResumen());
                pelicula.put("observaciones", peliculasDTO[i].getObservacion());

                peliculas.put(pelicula);
            }
        }catch(JSONException e) {
            System.err.println("Error al format el JSON");
            System.err.println(e);
        }
        catch(Exception e) {
            System.err.println("Existe un error al ejecutar la consulta");
            System.out.println(e);
        }
        return peliculas;
    }
    public JSONObject consultarId()
    {
        JSONObject pelicula = new JSONObject();
        try{
            peliculaDAO dao = new peliculaDAO();
            peliculaDTO peliculaDTO = dao.buscarPeliculaId(this._id);
            pelicula.put("id",peliculaDTO.getId());
            pelicula.put("directorId",peliculaDTO.getDirectorId());
            pelicula.put("titulo",peliculaDTO.getTitulo());
            pelicula.put("ano",peliculaDTO.getAno());
            pelicula.put("nacion",peliculaDTO.getNacion());
            pelicula.put("idioma",peliculaDTO.getIdioma());
            pelicula.put("color",peliculaDTO.getColor());
            pelicula.put("resumen",peliculaDTO.getResumen());
            pelicula.put("observaciones",peliculaDTO.getObservacion());
        }catch(JSONException e) {
            System.err.println("Error al format el JSON");
            System.err.println(e);
        }
        catch(Exception e) {
            System.err.println("Existe un error al ejecutar la consulta");
            System.out.println(e);
        }
        return pelicula;
    }  
    public Boolean eliminar()
    {
        peliculaDAO dao = new peliculaDAO();
        return dao.eliminar(this._id);
    }
    public Boolean Modificar()
    {
        peliculaDTO pelicula = new peliculaDTO();
        peliculaDAO dao = new peliculaDAO();
        try{
            pelicula.setId(this._id);
            pelicula.setDirectorId(this._director);
            pelicula.setTitulo(this._titulo);
            pelicula.setAno(this._ano);
            pelicula.setNacion(this._nacion);
            pelicula.setIdioma(this._idioma);
            pelicula.setColor(this._color);
            pelicula.setResumen(this._resumen);
            pelicula.setObservacion(this._observaciones);
        }catch(Exception e)
        {
            System.err.println("Error al crear el formato de fecha");
            System.err.println(e);
        }

        return dao.modificar(pelicula);
    }    
    
}

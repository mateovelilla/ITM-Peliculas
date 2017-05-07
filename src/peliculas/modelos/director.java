
package peliculas.modelos;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import peliculas.dao.directorDAO;
import peliculas.dto.directorDTO;

public class director {
    String _nombre,_nacion,_fechaNacimiento,_error,_format;
    int _id;
    public String getError() {
        return _error;
    }
    
    public director(int id,String nombre, String nacion, String fechaNacimiento)
    {
        this._nombre = nombre;
        this._fechaNacimiento = fechaNacimiento;
        this._nacion = nacion;
        this._format = "dd/MM/yyyy";
        this._id = id;
    }
    
    public Boolean validateNombre(){
        boolean response = false;
        if(this._nombre.length() == 0 || this._nombre.isEmpty())
        {
            this._error = "El nombre es obligatorio";
            response = false;
        }else
        {
            response = true;
        }
        return response;
    }
    
    public Boolean validateNacion()
    {
        boolean response = false;
                if(this._nacion.length() == 0 || this._nacion.isEmpty())
        {
            this._error = "la nación es obligatorio";
            response = false;
        }else
        {
            response = true;
        }
        return response;
    }
    
    public Boolean validateFechaNacimiento()
    {
        Boolean response = false;
        SimpleDateFormat sdf = new SimpleDateFormat(this._format);
        sdf.setLenient(false);
        try{
            Date date = sdf.parse(this._fechaNacimiento);
            return true;
        }catch(ParseException e)
        {
            this._error = "El formato de la fecha debe de ser :" + this._format;
            response = false;
        }
        return response;
    }
    
    public Boolean Guardar()
    {
        boolean response = false;
        if(this.validateNombre()){
            if(this.validateNacion())
            {
                if(this.validateFechaNacimiento())
                {
                    try{
                        directorDTO director = new directorDTO();
                        directorDAO dao = new directorDAO();
                        director.setNombre(this._nombre);
                        DateFormat formatter = new SimpleDateFormat(this._format);
                        Date date = formatter.parse(this._fechaNacimiento);
                        director.setFecha_nacimiento(date);
                        director.setNacion(this._nacion);
                        response = dao.crear(director);
                    }catch(ParseException e)
                    {
                        System.err.println("Error al crear el formato de fecha");
                    }
                    catch(Exception e)
                    {
                        System.err.println("Error");
                        System.err.println(e);
                    }
          
                } else
                {
                    response = false;
                }
            } else 
            {
                response = false;
            }
        
        } else
        {
            response = false;
        }
        return response;
    }
    
    public JSONArray consultar(){
        JSONArray directores = new JSONArray();
        try{
            directorDAO dao = new directorDAO();
            directorDTO dto = new directorDTO();
            dto.setNombre(this._nombre.isEmpty()?"":this._nombre);
            dto.setNacion(this._nacion.isEmpty()?"":this._nacion);
            if(!this._fechaNacimiento.isEmpty() && this._fechaNacimiento != null)
            {
                SimpleDateFormat sdf = new SimpleDateFormat(this._format);
                dto.setFecha_nacimiento(sdf.parse(this._fechaNacimiento));
            }   
            directorDTO[] directoresDTO = dao.buscarDirector(dto);
            for (int i = 0; i < directoresDTO.length; i++) {
                JSONObject director = new JSONObject();
                director.put("id",directoresDTO[i].getId());
                director.put("nombre", directoresDTO[i].getNombre());
                director.put("nacion", directoresDTO[i].getNacion());
                director.put("fechaNacimiento",directoresDTO[i].getFecha_nacimiento());
                directores.put(director);
            }
        }catch(JSONException e) {
            System.err.println("Error al format el JSON");
            System.err.println(e);
        }
        catch(Exception e) {
            System.err.println("Existe un error al ejecutar la consulta");
            System.out.println(e);
        }
        return directores;
    }
    public JSONArray traerDirectoresCombobox()
    {
        JSONArray actores = new JSONArray();
        try{
            directorDAO dao = new directorDAO();
            directorDTO dto = new directorDTO();
            dto.setNombre(this._nombre.isEmpty()?"":this._nombre);
            dto.setNacion(this._nacion.isEmpty()?"":this._nacion);  
            directorDTO[] actoresDTO = dao.directoresCombobox();
            for (int i = 0; i < actoresDTO.length; i++) {
                JSONObject actor = new JSONObject();
                actor.put("id",actoresDTO[i].getId());
                actor.put("nombre", actoresDTO[i].getNombre());
                actores.put(actor);
            }
        }catch(JSONException e) {
            System.err.println("Error al format el JSON");
            System.err.println(e);
        }
        catch(Exception e) {
            System.err.println("Existe un error al ejecutar la consulta");
            System.out.println(e);
        }
        return actores;
    }
    
    public Boolean eliminar()
    {
        directorDAO dao = new directorDAO();
        return dao.eliminar(this._id);
    }
    
    public JSONObject consultarId()
    {
        JSONObject director = new JSONObject();
        try{
            directorDAO dao = new directorDAO();
            directorDTO directorDTO = dao.buscarDirectorId(this._id);
            director.put("id",directorDTO.getId());
            director.put("nombre",directorDTO.getNombre());
            director.put("fechaNacimiento",directorDTO.getFecha_nacimiento().toString());
            director.put("nacion", directorDTO.getNacion());
        }catch(JSONException e) {
            System.err.println("Error al format el JSON");
            System.err.println(e);
        }
        catch(Exception e) {
            System.err.println("Existe un error al ejecutar la consulta");
            System.out.println(e);
        }
        return director;
    }
    public boolean Modificar()
    {
        directorDTO director = new directorDTO();
        directorDAO dao = new directorDAO();
        try{

            director.setId(this._id);
            director.setNombre(this._nombre);
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            director.setFecha_nacimiento(format.parse(this._fechaNacimiento));
            director.setNacion(this._nacion);
        }catch(ParseException e)
        {
            System.err.println("Error al crear el formato de fecha");
            System.err.println(e);
        }

        return dao.modificar(director);
    }
}

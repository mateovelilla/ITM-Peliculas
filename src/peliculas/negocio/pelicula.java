package peliculas.negocio;
import peliculas.modelos.*;
import peliculas.vistas.*;
import peliculas.dto.repartoDTO;
import org.json.*;
public class pelicula {
    String response;
    public String getResponse() {
        return response;
    }
    public Boolean Guardar(int director,String titulo, String nacion, String idioma, String color, String resumen,
            String observaciones,int ano)
    {
        peliculas.modelos.pelicula pelicula = new peliculas.modelos.pelicula(0,director,titulo, nacion, idioma, color, resumen, observaciones, ano);
        if(pelicula.Guardar())
        {
            this.response = "Registro exitoso";
            return true;
        } else {
            this.response = pelicula.getError(); 
            return false;
        }
    }
    
    public JSONArray consutar(String titulo,String nacion,String idioma, String color,int ano)
    {
        peliculas.modelos.pelicula pelicula  = new peliculas.modelos.pelicula(0,0,titulo, nacion, idioma, color, "", "", ano);
        return pelicula.consultar();
    }
    
    public Boolean Modificar(int id, int director,String titulo,String nacion, String idioma,String color,int ano,String resumen,String observaciones)
    {
        Boolean respuesta = false;
        peliculas.modelos.pelicula peliculaModel = new peliculas.modelos.pelicula(id,director,titulo, nacion, idioma, color, resumen, observaciones, ano);
        if(peliculaModel.Modificar())
        {
            respuesta = true;
        }else
        {
            this.response = peliculaModel.getError();
        }
        return respuesta;
    } 
    public void verEditarPelicula(int id)
    {
        peliculas.modelos.pelicula pelicula = new peliculas.modelos.pelicula(id,0,"" ,"", "", "", "", "", 0);
        JSONObject registro = pelicula.consultarId();
        modificarPelicula modPeli = new modificarPelicula();
        modPeli.setResultado(registro);
        modPeli.setVisible(true);
    }    
    public Boolean eliminar(int id)
    {
        peliculas.modelos.pelicula pelicula  = new peliculas.modelos.pelicula(id,0,"","", "","","","",0);
        if(pelicula.eliminar())
        {
            return true;
        }else
        {
            this.response = pelicula.getError();
            return false;
        }
    }
    public Boolean eliminarReparto(int id)
    {
        boolean respuesta = false;
        peliculas.modelos.reparto reparto  = new peliculas.modelos.reparto();
        if(reparto.eliminar(id))
        {
            respuesta = true;
        }
        return respuesta;

    }
    public JSONArray traerDirectores()
    {
        peliculas.modelos.director director  = new peliculas.modelos.director(0,"","","");
        return  director.traerDirectoresCombobox();
    }
    public JSONArray traerActores()
    {
        peliculas.modelos.actor actor  = new peliculas.modelos.actor(0, "","");
        return  actor.traerActoresCombobox();
    }
    public void buscarRepartos(int pelicula)
    {
        reparto reparto = new reparto();
        JSONArray repartos =  reparto.buscar(pelicula);
        repartos vistaReparto = new repartos();
        vistaReparto.setRepartos(repartos,pelicula);
        vistaReparto.setVisible(true);
        
    }
    public Boolean guardarReparto(String reparto,int actor,int peliculaId)
    {
        peliculas.modelos.reparto repartoModel = new peliculas.modelos.reparto();
        repartoDTO dto = new repartoDTO();
        dto.setActorId(actor);
        dto.setReparto(reparto);
        dto.setPeliculaId(peliculaId);
        if(repartoModel.Guardar(dto))
        {
            this.response = "Registro exitoso";
            return true;
        } else {
            return false;
        }
    }
}

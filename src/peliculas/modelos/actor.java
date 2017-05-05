
package peliculas.modelos;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import peliculas.dao.actorDAO;
import peliculas.dto.actorDTO;
public class actor {
    String _nombre,_nacion,_error;
    int _id;
    public String getError() {
        return _error;
    }
    
    public actor(int id,String nombre, String nacion)
    {
        this._nombre = nombre;
        this._nacion = nacion;
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
    
    public Boolean Guardar()
    {
        boolean response = false;
        actorDAO dao = new actorDAO();
        if(this.validateNombre()){
            if(this.validateNacion())
            {
                actorDTO actor = new actorDTO();
                actor.setNombre(this._nombre);
                actor.setNacion(this._nacion);
                response = dao.crear(actor);
                
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
        JSONArray actores = new JSONArray();
        try{
            actorDAO dao = new actorDAO();
            actorDTO dto = new actorDTO();
            dto.setNombre(this._nombre.isEmpty()?"":this._nombre);
            dto.setNacion(this._nacion.isEmpty()?"":this._nacion);  
            actorDTO[] actoresDTO = dao.buscarActor(dto);
            for (int i = 0; i < actoresDTO.length; i++) {
                JSONObject actor = new JSONObject();
                actor.put("id",actoresDTO[i].getId());
                actor.put("nombre", actoresDTO[i].getNombre());
                actor.put("nacion", actoresDTO[i].getNacion());
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
    public JSONArray traerActoresCombobox()
    {
        JSONArray actores = new JSONArray();
        try{
            actorDAO dao = new actorDAO();
            actorDTO dto = new actorDTO();
            dto.setNombre(this._nombre.isEmpty()?"":this._nombre);
            dto.setNacion(this._nacion.isEmpty()?"":this._nacion);  
            actorDTO[] actoresDTO = dao.actoresCombobox();
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
        actorDAO dao = new actorDAO();
        return dao.eliminar(this._id);
    }
    
    public JSONObject consultarId()
    {
        JSONObject actor = new JSONObject();
        try{
            actorDAO dao = new actorDAO();
            actorDTO actorDTO = dao.buscarActorId(this._id);
            actor.put("id",actorDTO.getId());
            actor.put("nombre",actorDTO.getNombre());
            actor.put("nacion", actorDTO.getNacion());
        }catch(JSONException e) {
            System.err.println("Error al format el JSON");
            System.err.println(e);
        }
        catch(Exception e) {
            System.err.println("Existe un error al ejecutar la consulta");
            System.out.println(e);
        }
        return actor;
    }
    public Boolean Modificar()
    {
        actorDTO actor = new actorDTO();
        actorDAO dao = new actorDAO();
        actor.setId(this._id);
        actor.setNombre(this._nombre);
        actor.setNacion(this._nacion);
        return dao.modificar(actor);
    }
}

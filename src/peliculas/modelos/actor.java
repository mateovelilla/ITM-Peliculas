
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
        if(this.validateNombre()){
            if(this.validateNacion())
            {
                return true;
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
                JSONArray directores = new JSONArray();
        try{
            JSONObject directOne = new JSONObject();
            directOne.put("id",1);
            directOne.put("nombre", "Rob marshal");
            JSONObject directTwo = new JSONObject();
            directTwo.put("id", 2);
            directTwo.put("nombre", "Espen Sandberg");
            directores.put(directOne);
            directores.put(directTwo);
        }catch(JSONException e)
        {
            System.err.println(e);
        }
        return directores;
    
    }    
    public Boolean eliminar()
    {
        return true;
    }
    
    public JSONObject consultarId()
    {
        JSONArray directores = new JSONArray();
        JSONObject director = null;
        try{
            JSONObject directOne = new JSONObject();
            directOne.put("id",1);
            directOne.put("nombre", "Rob marshal");
            directOne.put("nacion", "Estados unidos");
            JSONObject directTwo = new JSONObject();
            directTwo.put("id", 2);
            directTwo.put("nombre", "Espen Sandberg");
            directTwo.put("nacion", "Noruega");
            directores.put(directOne);
            directores.put(directTwo);
            for (int i = 0; i < directores.length(); i++)
            {
                if (directores.getJSONObject(i).getInt("id")==this._id)
                {
                    director =  directores.getJSONObject(i);
                }
            }
            
        }catch(JSONException e)
        {
            System.err.println(e);
        }
        return director;
    }
    public Boolean Modificar()
    {
        return true;
    }
}

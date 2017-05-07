package peliculas.modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import peliculas.dao.repartoDAO;
import peliculas.dto.repartoDTO;

public class reparto {
    JSONArray _repartos = new JSONArray();
    
    public reparto()
    {
        
        try{
            
            JSONObject actorOne = new JSONObject();
            actorOne.put("id",1);
            actorOne.put("peliculaId", 1);
            actorOne.put("actor", 1);
            actorOne.put("reparto", "Actor Principal");
            this._repartos.put(actorOne);
            JSONObject actorTwo = new JSONObject();
            actorTwo.put("id",2);
            actorTwo.put("peliculaId", 1);
            actorTwo.put("actor", 2);
            actorTwo.put("reparto", "Actor Secundario");
            this._repartos.put(actorTwo);
            
            
            JSONObject actorThree = new JSONObject();
            actorThree.put("id",1);
            actorThree.put("peliculaId", 2);
            actorThree.put("actor", 1);
            actorThree.put("reparto", "Actor Secundariol");
            this._repartos.put(actorThree);
            JSONObject actorFour = new JSONObject();
            actorFour.put("id",1);
            actorFour.put("peliculaId", 2);
            actorFour.put("actor", 2);
            actorFour.put("reparto", "Actor Principal");
            this._repartos.put(actorFour);
        }catch(JSONException e)
        {
            System.err.println(e);
        }
    }
    public JSONArray buscar(int pelicula)
    {
        JSONArray repartos = new JSONArray();
        try{
            repartoDAO dao = new repartoDAO();
            repartoDTO dto = new repartoDTO();
            dto.setPeliculaId(pelicula); 
            repartoDTO[] repartosDTO = dao.buscarReparto(dto);
            for (int i = 0; i < repartosDTO.length; i++) {
                JSONObject reparto = new JSONObject();
                reparto.put("id",repartosDTO[i].getId());
                reparto.put("actor", repartosDTO[i].getActorId());
                reparto.put("reparto", repartosDTO[i].getReparto());
                repartos.put(reparto);
            }
        }catch(JSONException e) {
            System.err.println("Error al format el JSON");
            System.err.println(e);
        }
        catch(Exception e) {
            System.err.println("Existe un error al ejecutar la consulta");
            System.out.println(e);
        }
        return repartos;
    }
    public Boolean eliminar(int id)
    {
        repartoDAO dao = new repartoDAO();
        return dao.eliminar(id);
    }
    public Boolean Guardar(repartoDTO reparto)
    {
        repartoDAO dao = new repartoDAO();
        return dao.crear(reparto);
    }
}

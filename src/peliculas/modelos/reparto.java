package peliculas.modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        JSONArray repartosBuscador = new JSONArray();
        try{
            for (int i = 0; i < this._repartos.length(); i++) {
            if(this._repartos.getJSONObject(i).getInt("peliculaId") == pelicula)
            {
                repartosBuscador.put(this._repartos.getJSONObject(i));
            }
        }
        }catch(JSONException e)
        {
            System.err.println("Error al buscar el reparto:\n"+e);
        }
        return repartosBuscador;
    }
    public Boolean eliminar(int id)
    {
        return true;
    }
    public Boolean Guardar(String reparto,int actor,int peliculaId)
    {
        return true;
    }
}

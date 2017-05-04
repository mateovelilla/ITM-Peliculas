/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peliculas.negocio;

import org.json.JSONArray;
import org.json.JSONObject;
import peliculas.vistas.modificarActor;

/**
 *
 * @author wong
 */
public class actor {
 String response;

    public String getResponse() {
        return response;
    }
    
    public Boolean Guardar(String nombre, String nacion)
    {
        peliculas.modelos.actor actor = new peliculas.modelos.actor(0,nombre, nacion);
        if(actor.Guardar())
        {
            response = "Registro exitoso";
            return true;
        } else {
            response = actor.getError(); 
            return false;
        }
    }
    public JSONArray consutar(int id,String nombre,String nacion)
    {
        peliculas.modelos.actor actor   = new peliculas.modelos.actor(id,nombre,nacion);
        return actor.consultar();        
    }
    public Boolean eliminar(int id)
    {
        peliculas.modelos.actor actor  = new peliculas.modelos.actor(id,"","");
        if(actor.eliminar())
        {
            return true;
        }else
        {
            this.response = actor.getError();
            return false;
        }
    }
    public void verEditarActor(int id)
    {
        peliculas.modelos.actor actor  = new peliculas.modelos.actor(id,"","");
        JSONObject registro = actor.consultarId();
        modificarActor modActor = new modificarActor();
        modActor.setResultado(registro);
        modActor.setVisible(true);
    }
    public Boolean Modificar(int id,String nombre,String nacion)
    {
        Boolean respuesta = true;
        peliculas.modelos.actor actorModel = new peliculas.modelos.actor(id,nombre,nacion);
        if(actorModel.Modificar())
        {
            respuesta = true;
        }else
        {
            this.response = actorModel.getError();
        }
        return respuesta;
    }   
}

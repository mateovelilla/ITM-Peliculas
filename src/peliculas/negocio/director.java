/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peliculas.negocio;
import peliculas.modelos.*;
import peliculas.vistas.*;
import org.json.*;

/**
 *
 * @author wong
 */
public class director {
    String response;

    public String getResponse() {
        return response;
    }
    
    public Boolean Guardar(String nombre, String nacion, String fechaNacimiento)
    {
        peliculas.modelos.director dtor = new peliculas.modelos.director(0,nombre, nacion, fechaNacimiento);
        if(dtor.Guardar())
        {
            response = "Registro exitoso";
            return true;
        } else {
            response = dtor.getError(); 
            return false;
        }
    }
    
    public JSONArray consutar(int id,String nombre,String nacion,String fechaNacimiento)
    {
        peliculas.modelos.director dtor  = new peliculas.modelos.director(id,nombre,nacion, fechaNacimiento);
        return dtor.consultar();        

    }
    
    public Boolean eliminar(int id)
    {
        peliculas.modelos.director dtor  = new peliculas.modelos.director(id,"","", "");
        if(dtor.eliminar())
        {
            return true;
        }else
        {
            this.response = dtor.getError();
            return false;
        }
    }
    
    public void verEditarDirector(int id)
    {
        peliculas.modelos.director dtor  = new peliculas.modelos.director(id,"","", "");
        JSONObject registro = dtor.consultarId();
        modificarDirector modDirect = new modificarDirector();
        modDirect.setResultado(registro);
        modDirect.setVisible(true);
    }
    public Boolean Modificar(int id,String nombre,String nacion,String fechaNacimiento)
    {
        Boolean respuesta = true;
        peliculas.modelos.director dtorModel = new peliculas.modelos.director(id,nombre,nacion,fechaNacimiento);
        if(dtorModel.Modificar())
        {
            respuesta = true;
        }else
        {
            this.response = dtorModel.getError();
        }
        return respuesta;
    }
}

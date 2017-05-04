
package peliculas.modelos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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
                    // aca se hace la inserción a la base de datos
                    return true;
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
            JSONObject directOne = new JSONObject();
            directOne.put("id",1);
            directOne.put("nombre", "Julian");
            directOne.put("nacion", "Angola");
            directOne.put("fechaNacimiento","16/06/1994");
            JSONObject directTwo = new JSONObject();
            directTwo.put("id", 2);
            directTwo.put("nombre", "Mateo");
            directTwo.put("nacion", "Alemania");
            directTwo.put("fechaNacimiento","16/06/1992");
            directores.put(directOne);
            directores.put(directTwo);
            
        }catch(JSONException e)
        {
            System.err.println(e);
        }
        return directores;
    }
    public JSONArray traerDirectoresCombobox()
    {
        JSONArray directores = new JSONArray();
        try{
            JSONObject directOne = new JSONObject();
            directOne.put("id",1);
            directOne.put("nombre", "Julian");
            JSONObject directTwo = new JSONObject();
            directTwo.put("id", 2);
            directTwo.put("nombre", "Mateo");
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
            directOne.put("nombre", "Julian");
            directOne.put("nacion", "Angola");
            directOne.put("fechaNacimiento","16/06/1994");
            JSONObject directTwo = new JSONObject();
            directTwo.put("id", 2);
            directTwo.put("nombre", "Mateo");
            directTwo.put("nacion", "Alemania");
            directTwo.put("fechaNacimiento","16/06/1992");
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

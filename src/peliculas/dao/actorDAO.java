package peliculas.dao;
import peliculas.dto.actorDTO;
import java.sql.*;
public class actorDAO {
   conexion con;
   public int countRow(ResultSet resultado)
   {
       int cont=0;
       try{
        while(resultado.next())
        {
            cont++;
        }
       }catch(Exception e)
       {
           System.err.println("Error al realizar el conteo");
       }
       return cont;       
   }
   public actorDTO[] buscarActor(actorDTO actor)
   {
       actorDTO[] actores =null;       
       try{
           con = new conexion();
           con.iniciarConnection();
       }catch(Exception e)
       {
           System.err.println("Error al iniciar la conexion");
           System.err.println(e);
       }
       
       try{
           PreparedStatement pstm = con.traerConexion().prepareStatement(
                   "SELECT * FROM actores " +
                   "WHERE nombre = ?"+
                    " OR nacion = ?"
           );
           pstm.setString(1,actor.getNombre());
           pstm.setString(2, actor.getNacion());
           int cont;
           try (ResultSet res = pstm.executeQuery()) {
               int size = this.countRow(res);
               actorDTO[] dto = new actorDTO[size];
               cont = 0;
               res.beforeFirst();// Retorna el cursor al principio
               while(res.next()){
                   actorDTO actorRow = new actorDTO();
                   actorRow.setId(res.getInt("id"));
                   actorRow.setNombre(res.getString("nombre"));
                   actorRow.setNacion(res.getString("nacion"));
                   dto[cont] = actorRow;
                   cont++;
               }
               actores = dto;
           }
           con.cerrarConexion();
       }catch(SQLException e){
           System.err.println("Error de base de datos");
           System.err.println(e);
       }
       return actores;
   }
   public actorDTO[] actoresCombobox()
   {
       actorDTO[] actores =null;       
       try{
           con = new conexion();
           con.iniciarConnection();
       }catch(Exception e)
       {
           System.err.println("Error al iniciar la conexion");
           System.err.println(e);
       }
       
       try{
           PreparedStatement pstm = con.traerConexion().prepareStatement(
                   "SELECT * FROM actores "
           );
           int cont;
           try (ResultSet res = pstm.executeQuery()) {
               int size = this.countRow(res);
               actorDTO[] dto = new actorDTO[size];
               cont = 0;
               res.beforeFirst();// Retorna el cursor al principio
               while(res.next()){
                   actorDTO actorRow = new actorDTO();
                   actorRow.setId(res.getInt("id"));
                   actorRow.setNombre(res.getString("nombre"));
                   dto[cont] = actorRow;
                   cont++;
               }
               actores = dto;
           }
           con.cerrarConexion();
       }catch(SQLException e){
           System.err.println("Error de base de datos");
           System.err.println(e);
       }
       return actores;
   }
   
   public actorDTO buscarActorId(int id)
   {
       actorDTO actor = new actorDTO();       
       try{
           con = new conexion();
           con.iniciarConnection();
       }catch(Exception e)
       {
           System.err.println("Error al iniciar la conexion");
           System.err.println(e);
       }
           try{
           PreparedStatement pstm = con.traerConexion().prepareStatement(
                   "SELECT * FROM actores "+
                    "where id = ?"
           );
           pstm.setInt(1, id);
           ResultSet res = pstm.executeQuery();
           if(res.next()){
                   actor.setId(res.getInt("id"));
                   actor.setNombre(res.getString("nombre"));
                   actor.setNacion(res.getString("nacion"));
               }
           con.cerrarConexion();
       }catch(SQLException e){
           System.err.println("Error de base de datos");
           System.err.println(e);
       }
           return actor;
   }
   public boolean crear(actorDTO actor)
   {
       boolean response = false;
       try{
           con = new conexion();
           con.iniciarConnection();
       }catch(Exception e)
       {
           System.err.println("Error al iniciar la conexion");
           System.err.println(e);
           response = false;
       }
       try{
            PreparedStatement pstm = con.traerConexion().prepareStatement(
            "insert into actores (nombre," +
            " nacion)" +
            " values(?,?)");
            pstm.setString(1, actor.getNombre());
            pstm.setString(2, actor.getNacion());
            if(pstm.executeUpdate() > 0)
            {
                response = true;
            }else{
                response = false;
            }
            con.cerrarConexion();
       }catch(SQLException sqE)
       {
           System.err.println("Error al insertar");
           System.err.println(sqE);
       }
       catch(Exception e){
           System.err.println("Error:");
           System.err.println(e);
       }
       return response;
   }
   public boolean eliminar(int id)
   {
       boolean respuesta = false;
       int resultado;
        try{
            con = new conexion();
            con.iniciarConnection();
        }catch(Exception e)
        {
            System.err.println("Error al iniciar la conexion");
            System.err.println(e);
            respuesta = false;
        }
       try{
           PreparedStatement pstm = con.traerConexion().prepareStatement(
                   "delete from actores " + " where id = ?");
            pstm.setInt(1, id);
            resultado = pstm.executeUpdate();
            if(resultado > 0){
                respuesta = true;
            }else
            {
                respuesta = false;
            }
            
       }catch(SQLException sqlEx)
       {
           System.err.println("Error al ejecutar el query");
           System.err.println(sqlEx);
       }
       catch(Exception e)
       {
           System.err.println("Error");
           System.err.println(e);
       }
       con.cerrarConexion();
       return respuesta;
   }
   public boolean modificar(actorDTO actor)
   {
       boolean respuesta = false;
        try{
            con = new conexion();
            con.iniciarConnection();
        }catch(Exception e)
        {
            System.err.println("Error al iniciar la conexion");
            System.err.println(e);
            respuesta = false;
        }
        try{
            PreparedStatement pstm = con.traerConexion().prepareStatement(
            "UPDATE actores SET nombre = ?," +
            "nacion = ? " +
            " WHERE id = ?");
            pstm.setString(1, actor.getNombre());
            pstm.setString(2, actor.getNacion());
            pstm.setInt(3, actor.getId());
            if(pstm.executeUpdate() > 0)
            {
                respuesta = true;
            }else{
                respuesta = false;
            }
            con.cerrarConexion();
       }catch(SQLException sqE)
       {
           System.err.println("Error al insertar");
           System.err.println(sqE);
       }
       catch(Exception e){
           System.err.println("Error:");
           System.err.println(e);
       }
       return respuesta;
        
   }
}
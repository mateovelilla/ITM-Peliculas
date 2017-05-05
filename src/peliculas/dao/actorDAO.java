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
}

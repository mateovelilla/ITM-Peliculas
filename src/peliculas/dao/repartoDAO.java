package peliculas.dao;
import peliculas.dto.repartoDTO;
import java.sql.*;
public class repartoDAO {
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
   public repartoDTO[] buscarReparto(repartoDTO reparto)
   {
       repartoDTO[] repartos = null;       
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
                "SELECT * FROM reparto " +
                "WHERE peliculaId = ?");
        pstm.setInt(1,reparto.getPeliculaId());
        int cont;
        try (ResultSet res = pstm.executeQuery()) {
            int size = this.countRow(res);
            repartoDTO[] dto = new repartoDTO[size];
               cont = 0;
               res.beforeFirst();// Retorna el cursor al principio
               while(res.next()){
                   repartoDTO repartoRow = new repartoDTO();
                   repartoRow.setId(res.getInt("id"));
                   repartoRow.setPeliculaId(res.getInt("peliculaId"));
                   repartoRow.setActorId(res.getInt("actorId"));
                   repartoRow.setReparto(res.getString("personaje"));
                   dto[cont] = repartoRow;
                   cont++;
               }
               repartos = dto;
           }
        con.cerrarConexion();
        
       }catch(SQLException e){
           System.err.println("Error de base de datos");
           System.err.println(e);
       }
       return repartos;
   }
}

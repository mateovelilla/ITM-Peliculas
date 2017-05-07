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
   public boolean crear(repartoDTO reparto)
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
            "insert into reparto (peliculaId," +
            "actorId,"+
            "personaje)"+
            " values(?,?,?)");
            pstm.setInt(1, reparto.getPeliculaId());
            pstm.setInt(2, reparto.getActorId());
            pstm.setString(3, reparto.getReparto());
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
                   "delete from reparto " + " where id = ?");
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
}

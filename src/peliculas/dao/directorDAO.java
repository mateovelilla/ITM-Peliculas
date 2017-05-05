package peliculas.dao;
import peliculas.dto.directorDTO;
import java.sql.*;
public class directorDAO {
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
   public directorDTO[] buscarDirector(directorDTO director)
   {
       directorDTO[] directores =null;       
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
                "SELECT * FROM directores " +
                "WHERE nombre = ?"+
                 " OR fechaNacimiento = ?"+
                 " OR nacion = ?");
         pstm.setString(1,director.getNombre());
        if(director.getFecha_nacimiento() != null){
            java.sql.Date sqlTime = new java.sql.Date(director.getFecha_nacimiento().getTime());
            pstm.setDate(2,sqlTime );
            pstm.setString(3,director.getNacion());
        }else{
            pstm.setString(2, "");
             pstm.setString(3, director.getNacion());
        }
        int cont;
        try (ResultSet res = pstm.executeQuery()) {
            int size = this.countRow(res);
            directorDTO[] dto = new directorDTO[size];
               cont = 0;
               res.beforeFirst();// Retorna el cursor al principio
               while(res.next()){
                   directorDTO directorRow = new directorDTO();
                   directorRow.setId(res.getInt("id"));
                   directorRow.setNombre(res.getString("nombre"));
                   directorRow.setNacion(res.getString("nacion"));
                   directorRow.setFecha_nacimiento(res.getDate("fechaNacimiento"));
                   dto[cont] = directorRow;
                   cont++;
               }
               directores = dto;
           }
        con.cerrarConexion();
        
       }catch(SQLException e){
           System.err.println("Error de base de datos");
           System.err.println(e);
       }
       return directores;
   }
}

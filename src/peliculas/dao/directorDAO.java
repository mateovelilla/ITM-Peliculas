package peliculas.dao;
import peliculas.dto.directorDTO;
import java.sql.*;
import java.text.SimpleDateFormat;
public class directorDAO {
   conexion con;
   String _format = "dd/MM/yyyy";
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
   public boolean crear(directorDTO director)
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
            "insert into directores (nombre," +
            "fechaNacimiento,"+
            " nacion)" +
            " values(?,?,?)");
            pstm.setString(1, director.getNombre());
            java.sql.Date sqlTime = new java.sql.Date(director.getFecha_nacimiento().getTime());
            pstm.setDate(2, sqlTime);
            pstm.setString(3, director.getNacion());
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
   public directorDTO[] directoresCombobox()
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
                   "SELECT * FROM directores "
           );
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
   public directorDTO buscarDirectorId(int id)
   {
       directorDTO director = new directorDTO();       
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
                   "SELECT * FROM directores "+
                    "where id = ?"
           );
           pstm.setInt(1, id);
           ResultSet res = pstm.executeQuery();
           if(res.next()){
                   director.setId(res.getInt("id"));
                   director.setNombre(res.getString("nombre"));
                   director.setFecha_nacimiento(res.getDate("fechaNacimiento"));
                   director.setNacion(res.getString("nacion"));
               }
           con.cerrarConexion();
       }catch(SQLException e){
           System.err.println("Error de base de datos");
           System.err.println(e);
       }
           return director;
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
                   "delete from directores " + " where id = ?");
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
      public Boolean modificar(directorDTO director)
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
            "UPDATE directores SET nombre = ?," +
            "fechaNacimiento = ?,"+
            "nacion = ? " +
            " WHERE id = ?");
            pstm.setString(1, director.getNombre());
            java.sql.Date sqlTime = new java.sql.Date(director.getFecha_nacimiento().getTime());
            pstm.setDate(2, sqlTime);
            pstm.setString(3, director.getNacion());
            pstm.setInt(4, director.getId());
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

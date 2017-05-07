package peliculas.dao;
import peliculas.dto.peliculaDTO;
import java.sql.*;
public class peliculaDAO {
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
   public peliculaDTO[] buscarPelicula(peliculaDTO pelicula)
   {
       peliculaDTO[] peliculas = null;       
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
                "SELECT * FROM peliculas " +
                "WHERE titulo = ?"+
                " OR año = ?"+
                " OR nacion = ?"+
                " OR idioma = ?"+
                " OR color = ?"+
                " OR resumen = ?"+
                " OR observacion = ?");
        pstm.setString(1,pelicula.getTitulo());
        pstm.setInt(2,pelicula.getAno());
        pstm.setString(3,pelicula.getNacion());
        pstm.setString(4,pelicula.getIdioma());
        pstm.setString(5,pelicula.getColor());
        pstm.setString(6,pelicula.getResumen());
        pstm.setString(7,pelicula.getObservacion());
        int cont;
        try (ResultSet res = pstm.executeQuery()) {
            int size = this.countRow(res);
            peliculaDTO[] dto = new peliculaDTO[size];
               cont = 0;
               res.beforeFirst();// Retorna el cursor al principio
               while(res.next()){
                   peliculaDTO peliculaRow = new peliculaDTO();
                   peliculaRow.setId(res.getInt("id"));
                   peliculaRow.setDirectorId(res.getInt("directorId"));
                   peliculaRow.setAno(res.getInt("año"));
                   peliculaRow.setTitulo(res.getString("titulo"));
                   peliculaRow.setNacion(res.getString("nacion"));
                   peliculaRow.setIdioma(res.getString("idioma"));
                   peliculaRow.setColor(res.getString("color"));
                   peliculaRow.setResumen(res.getString("resumen"));
                   peliculaRow.setObservacion(res.getString("observacion"));
                   dto[cont] = peliculaRow;
                   cont++;
               }
               peliculas = dto;
           }
        con.cerrarConexion();
        
       }catch(SQLException e){
           System.err.println("Error de base de datos");
           System.err.println(e);
       }
       return peliculas;
   }
   public boolean crear(peliculaDTO pelicula)
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
            "insert into peliculas (directorId," +
            "titulo,"+
            "año,"+
            "nacion,"+
            "idioma,"+
            "color,"+
            "resumen,"+
            "observacion)"+
            " values(?,?,?,?,?,?,?,?)");
            pstm.setInt(1, pelicula.getDirectorId());
            pstm.setString(2, pelicula.getTitulo());
            pstm.setInt(3, pelicula.getAno());
            pstm.setString(4, pelicula.getNacion());
            pstm.setString(5, pelicula.getIdioma());
            pstm.setString(6, pelicula.getColor());
            pstm.setString(7, pelicula.getResumen());
            pstm.setString(8, pelicula.getObservacion());
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
   
   public peliculaDTO buscarPeliculaId(int id)
   {
       peliculaDTO pelicula = new peliculaDTO();       
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
                   "SELECT * FROM peliculas "+
                    "where id = ?"
           );
           pstm.setInt(1, id);
           ResultSet res = pstm.executeQuery();
           if(res.next()){
               pelicula.setId(res.getInt("id"));
               pelicula.setDirectorId(res.getInt("directorId"));
               pelicula.setTitulo(res.getString("titulo"));
               pelicula.setAno(res.getInt("año"));
               pelicula.setNacion(res.getString("nacion"));
               pelicula.setIdioma(res.getString("idioma"));
               pelicula.setColor(res.getString("color"));
               pelicula.setResumen(res.getString("resumen"));
               pelicula.setObservacion(res.getString("observacion"));

           }
           con.cerrarConexion();
       }catch(SQLException e){
           System.err.println("Error de base de datos");
           System.err.println(e);
       }
           return pelicula;
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
                   "delete from peliculas " + " where id = ?");
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
   public boolean Modificar(peliculaDTO pelicula)
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
            "UPDATE peliculas SET directorId = ?," +
            "titulo = ?,"+
            "año = ? " +
            "nacion= ? " +
            "idioma = ? " +
            "color = ? " +
            "resumen = ? " +
            "observacion = ? " +
            " WHERE id = ?");
            pstm.setInt(1,pelicula.getDirectorId());
            pstm.setString(2, pelicula.getTitulo());
            pstm.setInt(3, pelicula.getAno());
            pstm.setString(4, pelicula.getNacion());
            pstm.setString(5, pelicula.getIdioma());
            pstm.setString(6, pelicula.getColor());
            pstm.setString(7, pelicula.getResumen());
            pstm.setString(8, pelicula.getObservacion());
            pstm.setInt(9, pelicula.getId());
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
   public boolean modificar(peliculaDTO pelicula)
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
            "UPDATE peliculas SET directorId = ?," +
            "titulo = ?,"+
            "año = ?,"+
            "nacion= ?,"+
            "idioma = ?,"+
            "color = ?,"+
            "resumen = ?,"+
            "observacion = ?"+
            " WHERE id = ?");
            pstm.setInt(1, pelicula.getDirectorId());
            pstm.setString(2, pelicula.getTitulo());
            pstm.setInt(3, pelicula.getAno());
            pstm.setString(4, pelicula.getNacion());
            pstm.setString(5, pelicula.getIdioma());
            pstm.setString(6, pelicula.getColor());
            pstm.setString(7, pelicula.getResumen());
            pstm.setString(8, pelicula.getObservacion());
            pstm.setInt(9, pelicula.getId());
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

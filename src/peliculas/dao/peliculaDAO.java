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
}

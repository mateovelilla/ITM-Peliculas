package peliculas.dao;
import java.sql.*;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class conexion {
    static int lport = 4321; // puerto al que se le va a hacer port forwarding con ssh
    static String rhost = "127.0.0.1";// Dominion forwarding
    static int rport = 3306;//puerto de la maquina remota
    static int Sport=2222;// Puerto de la conexion ssh
    static String Suser = "vagrant";
    static String Spassword = "vagrant";
    static String Shost = "127.0.0.1";
    static String login = "root";
    static String password = "";
    static String db ="peliculas";
    static String dburl = "jdbc:mysql://localhost:" + lport + "/peliculas";
    public static Session session;
    Connection conexion = null;
    
    public static void conexionSsh()
    {              
        try
        {
            JSch jsch = new JSch();
            session = jsch.getSession(Suser, Shost, Sport);
            session.setPassword(Spassword);
            session.setConfig("StrictHostKeyChecking", "no");
            System.out.println("Estableciendo conexion...");
            session.connect();
            int assinged_port=session.setPortForwardingL(lport, rhost, rport);
            System.out.println("localhost:"+assinged_port+" -> "+rhost+":"+rport);
        }catch(Exception e){
            System.err.print(e);
        }
    }
    public void iniciarConnection()
    {
        try{
            conexionSsh();
        }catch(Exception e)
        {
            System.err.println("Error al abrir la conexion ssh"+ e.getMessage());
        }
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(dburl,login,password);
            if (conexion!=null){
                System.out.println("Conexión a base de datos "+db+" OK");
            }
        }catch(SQLException e)
        {
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        catch(Exception e)
        {
            System.err.println("error: "+e.getMessage());
        }
    }
    
    public Connection traerConexion()
    {
        return this.conexion;
    }
    public void cerrarConexion()
    {
        try{
            conexion.close();
            session.disconnect();
        }catch(Exception e)
        {
            System.err.println("Error al cerrar las conexiones");
            System.err.println(e);
        }        
    }
}

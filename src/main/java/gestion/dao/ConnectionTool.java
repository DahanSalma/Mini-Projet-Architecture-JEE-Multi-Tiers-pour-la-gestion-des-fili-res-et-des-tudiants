package gestion.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTool {

    private static Connection connexion = null;

    private static void connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/smi_2024";
            String user = "root";
            String password = "sAlmA&@dAhAn@";

            connexion = DriverManager.getConnection(url, user, password);

            System.out.println("Connexion bien �tablie ...");
        }
        catch(Exception ex){
            System.out.println("Probleme de connexion ..."+ex.getMessage());
        }
    }

    public static Connection getConnexion () {
        if(connexion == null)
            connect();

        return connexion;
    }
}

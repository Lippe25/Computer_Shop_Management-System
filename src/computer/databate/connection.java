package computer.databate;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connection {

    private boolean testCon = false;
    private Connection con = null;

    connection() {
        Properties props = new Properties();
        try {
            FileInputStream fis = new FileInputStream("conf.properties");
            props.load(fis);

            String driverSQL = props.getProperty("jdbc.driver.class");
            String urlSQL = props.getProperty("jdbc.url");
            String login = props.getProperty("jdbc.login");
            String pwd = props.getProperty("jdbc.password");

            Class.forName(driverSQL);
            con = DriverManager.getConnection(urlSQL, login, pwd);

            testCon = true;

            System.out.println("Connected to database !");

        } catch (ClassNotFoundException | IOException | SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Connection getCon() {
        return this.con;
    }

    public boolean getTestConnection(){
        return this.testCon;
    }
}

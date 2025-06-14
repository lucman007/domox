package comun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Li
 */
public class Conexion {

    public Conexion() {
    }

    public Connection conectar() {

        Connection conn = null;
        try {
            //conn = DriverManager.getConnection("jdbc:mysql://192.168.0.34/gestcom?user=lucs&password=taobao2016&serverTimezone=UTC");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/inventario?user=root&useSSL=false&serverTimezone=UTC");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return conn;

    }

}

package Connection.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private final String database;

    public Connection getConnection() {
        Connection cn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + database,
                    "root", "mysql");
        } catch (SQLException | ClassNotFoundException
                | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return cn;
    }

    public ConnectionDB() {
        this.database = "hr";
    }
}

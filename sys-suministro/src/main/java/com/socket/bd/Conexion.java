package com.socket.bd;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
    
    public static Connection conectarBD() throws IOException, SQLException {
        InputStream input = Conexion.class.getClassLoader().getResourceAsStream("config.properties");
        Properties prop = new Properties();
        prop.load(input);

        return DriverManager.getConnection(
            prop.getProperty("db.url"), 
            prop.getProperty("db.user"), 
            prop.getProperty("db.password")
        );
    }
}

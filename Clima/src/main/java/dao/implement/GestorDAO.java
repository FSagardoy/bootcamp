package dao.implement;

import com.franciscosagardoy.Pais;

import java.sql.*;
import java.util.ArrayList;

public class GestorDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/bootcamp";
    private static final String USER = "root";
    private static final String PASSWORD = "bootcamp2017";
    private Connection connection = null;
    private static GestorDAO instancia = null;

    private GestorDAO() {
        conectar();
    }

    public static GestorDAO getInstancia() {
        if(instancia == null) {
            instancia = new GestorDAO();
        }
        return instancia;
    }

    public Connection getConnection() {
        return connection;
    }

    protected void conectar(){
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void desconectar() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        connection = null;
    }


    public int executeNonQuery(PreparedStatement consulta) throws SQLException {
        int execute = consulta.executeUpdate();
        this.desconectar();
        return execute;
    }

    public ResultSet executeQuery(PreparedStatement consulta) throws SQLException {
        ResultSet res = consulta.executeQuery();
        res.close();
        this.desconectar();
        return res;
    }

}

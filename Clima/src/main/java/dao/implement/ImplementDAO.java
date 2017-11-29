package dao.implement;

import dao.interfaz.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class ImplementDAO implements DAO{

    private GestorDAO gestor;

    public ImplementDAO(){
        this.gestor = GestorDAO.getInstancia();
    }

    public GestorDAO getGestor() {
        return gestor;
    }

    protected int executeNonQuery(PreparedStatement consulta) throws SQLException {
        int execute = consulta.executeUpdate();
        gestor.desconectar();
        return execute;
    }

    protected ResultSet executeQuery(PreparedStatement consulta) throws SQLException {
        ResultSet res = consulta.executeQuery();
        res.close();
        gestor.desconectar();
        return res;
    }

    public abstract int insert(Object object);

    public abstract int update(Object object);

    public abstract int delete(Object object);

    public ArrayList<Object> select(){
        return null;
    }


}

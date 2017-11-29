package dao.implement;


import com.franciscosagardoy.Provincia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProvinciaImplementDAO extends ImplementDAO{

    public ProvinciaImplementDAO(){}

    public int insert(Object object){
        Provincia provincia = (Provincia) object;
        int resultado = 0;
        getGestor().conectar();
        String consulta = "insert into provincias (nombre, abreviatura, superficie, capital, idpais) valus (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getGestor().getConnection().prepareStatement(consulta);
            preparedStatement.setString(1, provincia.getNombre());
            preparedStatement.setString(2, provincia.getAbreviatura());
            preparedStatement.setInt(3, provincia.getSuperficie());
            preparedStatement.setString(4, provincia.getCapital());
            preparedStatement.setInt(5, provincia.getPais().getIdPais());
            resultado = executeNonQuery(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public int update(Object object){
        Provincia provincia = (Provincia) object;
        int resultado = 0;
        getGestor().conectar();
        String consulta = "update provincias set nombre = ?, abreviatura = ?, superficie = ?, capital = ? where idprovincia = ?";
        try {
            PreparedStatement preparedStatement = getGestor().getConnection().prepareStatement(consulta);
            preparedStatement.setString(1, provincia.getNombre());
            preparedStatement.setString(2, provincia.getAbreviatura());
            preparedStatement.setInt(3, provincia.getSuperficie());
            preparedStatement.setString(4, provincia.getCapital());
            preparedStatement.setInt(5, provincia.getIdProvincia());
            resultado = executeNonQuery(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public int delete(Object object){
        Provincia provincia = (Provincia) object;
        int resultado = 0;
        getGestor().conectar();
        String consulta = "delete from paises where idpais = ?";
        try {
            PreparedStatement preparedStatement = getGestor().getConnection().prepareStatement(consulta);
            preparedStatement.setInt(1, provincia.getIdProvincia());
            resultado = executeNonQuery(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }


    public ArrayList<Object> select() {
        getGestor().conectar();
        ArrayList<Object> resultado = new ArrayList<Object>();
        String consulta = "select * from provincias";
        try {
            Statement st = getGestor().getConnection().createStatement();
            ResultSet res = st.executeQuery(consulta);
            while (res.next()){
                Provincia provincia = new Provincia();
                provincia.setIdProvincia(res.getInt(1));
                provincia.setNombre(res.getString(2));
                provincia.setAbreviatura(res.getString(3));
                provincia.setSuperficie(res.getInt(4));
                provincia.setCapital(res.getString(5));
                provincia.getPais().setIdPais(res.getInt(6));
                resultado.add(provincia);
            }
            res.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}

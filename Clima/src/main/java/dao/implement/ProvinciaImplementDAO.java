package dao.implement;


import com.franciscosagardoy.Provincia;
import dao.interfaz.ProvinciaDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProvinciaImplementDAO implements ProvinciaDAO {
    private GestorDAO conexion;

    public ProvinciaImplementDAO(){
        this.conexion = GestorDAO.getInstancia();
    }

    public int insertProvincia(Provincia provincia){
        int resultado = 0;
        conexion.conectar();
        String consulta = "insert into provincias (nombre, abreviatura, superficie, capital, idpais) valus (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(consulta);
            preparedStatement.setString(1, provincia.getNombre());
            preparedStatement.setString(2, provincia.getAbreviatura());
            preparedStatement.setInt(3, provincia.getSuperficie());
            preparedStatement.setString(4, provincia.getCapital());
            preparedStatement.setInt(5, provincia.getPais().getIdPais());
            resultado = conexion.executeNonQuery(preparedStatement);
//            conexion.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public int updateProvincia(Provincia provincia){
        int resultado = 0;
        conexion.conectar();
        String consulta = "update provincias set nombre = ?, abreviatura = ?, superficie = ?, capital = ? where idprovincia = ?";
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(consulta);
            preparedStatement.setString(1, provincia.getNombre());
            preparedStatement.setString(2, provincia.getAbreviatura());
            preparedStatement.setInt(3, provincia.getSuperficie());
            preparedStatement.setString(4, provincia.getCapital());
            preparedStatement.setInt(5, provincia.getIdProvincia());
            resultado = conexion.executeNonQuery(preparedStatement);
//            conexion.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public int deleteProvincia(Provincia provincia){
        int resultado = 0;
        conexion.conectar();
        String consulta = "delete from paises where idpais = ?";
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(consulta);
            preparedStatement.setInt(1, provincia.getIdProvincia());
            resultado = conexion.executeNonQuery(preparedStatement);
//            conexion.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }


    public ArrayList<Provincia> getProvincias() {
        conexion.conectar();
        ArrayList<Provincia> resultado = new ArrayList<>();
        String consulta = "select * from provincias";
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(consulta);
            ResultSet res = conexion.executeQuery(preparedStatement);
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
//            conexion.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}

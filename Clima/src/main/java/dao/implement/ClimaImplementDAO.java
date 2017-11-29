package dao.implement;


import com.franciscosagardoy.Clima;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClimaImplementDAO extends ImplementDAO{

    public ClimaImplementDAO(){}

    @Override
    public int insert(Object object) {
        Clima clima = (Clima) object;
        int resultado = 0;
        getGestor().conectar();
        String consulta = "insert into climas (temperatura, descripcion, idviento, idatmosfera, idlocalidad, tempmin, tempmax) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getGestor().getConnection().prepareStatement(consulta);
            preparedStatement.setInt(1, clima.getTemperatura());
            preparedStatement.setString(2, clima.getDescripcion());
            preparedStatement.setInt(3, clima.getViento().getIdViento());
            preparedStatement.setInt(4, clima.getAtmosfera().getIdAtmosfera());
            preparedStatement.setInt(5, clima.getLocalidad().getIdLocalidad());
            preparedStatement.setInt(6, clima.getTempmin());
            preparedStatement.setInt(7, clima.getTempmax());
            resultado = executeNonQuery(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }


    @Override
    public int update(Object object){
        Clima clima = (Clima) object;
        int resultado = 0;
        getGestor().conectar();
        String consulta = "update climas set temperatura = ?, descripcion = ?, tempmin = ?, tempmax = ? where idclima = ?";
        try {
            PreparedStatement preparedStatement = getGestor().getConnection().prepareStatement(consulta);
            preparedStatement.setInt(1, clima.getTemperatura());
            preparedStatement.setString(2, clima.getDescripcion());
            preparedStatement.setInt(3, clima.getTempmin());
            preparedStatement.setInt(4, clima.getTempmax());
            preparedStatement.setInt(5, clima.getIdClima());
            resultado = executeNonQuery(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public int delete(Object object){
        Clima clima = (Clima) object;
        int resultado = 0;
        getGestor().conectar();
        String consulta = "delete from clima where idclima = ?";
        try {
            PreparedStatement preparedStatement = getGestor().getConnection().prepareStatement(consulta);
            preparedStatement.setInt(1, clima.getIdClima());
            resultado = executeNonQuery(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public ArrayList<Object> select() {
        getGestor().conectar();
        ArrayList<Object> resultado = new ArrayList<Object>();
        String consulta = "select c.idclima, c.fecha, c.temperatura, c.descripcion, v.idviento, v.direccion, v.velocidad, a.idatmosfera, a.humedad, a.presion, a.visibilidad, a.ambiente_asc, p.idprovincia, p.nombre, c.tempmin, c.tempmax from climas c join vientos v on c.idviento = v.idviento join atmosferas a on c.idatmosfera = a.idatmosfera join provincias p on c.idprovincia = p.idprovincia where fecha between NOW() and DATE_ADD(NOW(), INTERVAL 10 DAY)";
        try {
            Statement st = getGestor().getConnection().createStatement();
            ResultSet res = st.executeQuery(consulta);
            while (res.next()){
                Clima clima = new Clima();
                clima.setIdClima(res.getInt(1));
                clima.setFecha(res.getDate(2));
                clima.setTemperatura(res.getInt(3));
                clima.setDescripcion(res.getString(4));
                clima.getViento().setIdViento(res.getInt(5));
                clima.getViento().setDireccion(res.getString(6));
                clima.getViento().setVelocidad(res.getInt(7));
                clima.getAtmosfera().setIdAtmosfera(res.getInt(8));
                clima.getAtmosfera().setHumedad(res.getInt(9));
                clima.getAtmosfera().setPresion(res.getDouble(10));
                clima.getAtmosfera().setVisibilidad(res.getInt(11));
                clima.getAtmosfera().setAmbienteAscendente(res.getInt(12));
                clima.getLocalidad().setIdLocalidad(res.getInt(13));
                clima.getLocalidad().setNombre(res.getString(14));
                clima.setTempmin(res.getInt(15));
                clima.setTempmax(res.getInt(16));
                resultado.add(clima);
            }
            res.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return resultado;
    }
}

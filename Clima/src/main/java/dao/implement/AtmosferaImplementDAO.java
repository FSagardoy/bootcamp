package dao.implement;

import com.franciscosagardoy.Atmosfera;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtmosferaImplementDAO extends ImplementDAO {

    public AtmosferaImplementDAO(){}

    public int insert(Object object){
        Atmosfera atmosfera = (Atmosfera) object;
        int resultado = 0;
        getGestor().conectar();
        String consulta = "insert into atmosferas (humedad, presion, visibilidad, ambiente_asc) values (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getGestor().getConnection().prepareStatement(consulta);
            preparedStatement.setInt(1, atmosfera.getHumedad());
            preparedStatement.setDouble(2, atmosfera.getPresion());
            preparedStatement.setInt(3, atmosfera.getVisibilidad());
            preparedStatement.setInt(4, atmosfera.getAmbienteAscendente());
            resultado = executeNonQuery(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public int update(Object object){
        Atmosfera atmosfera = (Atmosfera) object;
        int resultado = 0;
        getGestor().conectar();
        String consulta = "update atmosferas set humedad = ?, presion = ?, visibilidad = ?, ambiente_asc = ? where idatmosfera = ?";
        try {
            PreparedStatement preparedStatement = getGestor().getConnection().prepareStatement(consulta);
            preparedStatement.setInt(1, atmosfera.getHumedad());
            preparedStatement.setDouble(2, atmosfera.getPresion());
            preparedStatement.setInt(3, atmosfera.getVisibilidad());
            preparedStatement.setInt(4, atmosfera.getAmbienteAscendente());
            preparedStatement.setInt(5, atmosfera.getIdAtmosfera());
            resultado = executeNonQuery(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public int delete(Object object){
        Atmosfera atmosfera = (Atmosfera) object;
        int resultado = 0;
        getGestor().conectar();
        String consulta = "delete from atmosferas where idatmosfera = ?";
        try {
            PreparedStatement preparedStatement = getGestor().getConnection().prepareStatement(consulta);
            preparedStatement.setInt(1, atmosfera.getHumedad());
            resultado = executeNonQuery(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}

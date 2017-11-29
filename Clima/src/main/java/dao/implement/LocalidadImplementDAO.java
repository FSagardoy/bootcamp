package dao.implement;

import com.franciscosagardoy.Localidad;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LocalidadImplementDAO extends ImplementDAO {

    public LocalidadImplementDAO() {
    }

    @Override
    public int insert(Object object) {
        Localidad localidad = (Localidad) object;
        int resultado = 0;
        getGestor().conectar();
        String consulta = "insert into localidades (nombre) values (?)";
        try {
            PreparedStatement preparedStatement = getGestor().getConnection().prepareStatement(consulta);
            preparedStatement.setString(1, localidad.getNombre());
            resultado = executeNonQuery(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public int update(Object object) {
        Localidad localidad = (Localidad) object;
        int resultado = 0;
        getGestor().conectar();
        String consulta = "update localidades set nombre = ? where idlocalidad = ?";
        try {
            PreparedStatement preparedStatement = getGestor().getConnection().prepareStatement(consulta);
            preparedStatement.setString(1, localidad.getNombre());
            preparedStatement.setInt(2, localidad.getIdLocalidad());
            resultado = executeNonQuery(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public int delete(Object object) {
        Localidad localidad = (Localidad) object;
        int resultado = 0;
        getGestor().conectar();
        String consulta = "delete from localidades where idlocalidad = ?";
        try {
            PreparedStatement preparedStatement = getGestor().getConnection().prepareStatement(consulta);
            preparedStatement.setInt(1, localidad.getIdLocalidad());
            resultado = executeNonQuery(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}

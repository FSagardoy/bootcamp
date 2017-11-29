package dao.implement;


import com.franciscosagardoy.Viento;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VientoImplementDAO extends ImplementDAO{

    public VientoImplementDAO(){
    }

    public int insert(Object object){
        Viento viento = (Viento) object;
        int resultado = 0;
        getGestor().conectar();
        String consulta = "insert into vientos (velocidad, direccion) values (?,?)";
        try {
            PreparedStatement preparedStatement = getGestor().getConnection().prepareStatement(consulta);
            preparedStatement.setInt(1, viento.getVelocidad());
            preparedStatement.setString(2, viento.getDireccion());
            resultado = executeNonQuery(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public int update(Object object){
        Viento viento = (Viento) object;
        int resultado = 0;
        getGestor().conectar();
        String consulta = "update vientos set velocidad = ?, direccion = ? where idviento = ?";
        try {
            PreparedStatement preparedStatement = getGestor().getConnection().prepareStatement(consulta);
            preparedStatement.setInt(1, viento.getVelocidad());
            preparedStatement.setString(2, viento.getDireccion());
            preparedStatement.setInt(3, viento.getIdViento());
            resultado = executeNonQuery(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public int delete(Object object){
        Viento viento = (Viento) object;
        int resultado = 0;
        getGestor().conectar();
        String consulta = "delete from vientos where idviento = ?";
        try {
            PreparedStatement preparedStatement = getGestor().getConnection().prepareStatement(consulta);
            preparedStatement.setInt(1, viento.getIdViento());
            resultado = executeNonQuery(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}

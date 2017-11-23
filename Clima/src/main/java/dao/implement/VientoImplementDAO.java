package dao.implement;


import com.franciscosagardoy.Viento;
import dao.interfaz.VientoDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VientoImplementDAO implements VientoDAO {
    private GestorDAO conexion;

    public VientoImplementDAO(){
        this.conexion = GestorDAO.getInstancia();
    }

    public int insertViento(Viento viento){
        int resultado = 0;
        conexion.conectar();
        String consulta = "insert into vientos (velocidad, direccion) values (?,?)";
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(consulta);
            preparedStatement.setInt(1, viento.getVelocidad());
            preparedStatement.setString(2, viento.getDireccion());
            resultado = conexion.executeNonQuery(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public int updateViento(Viento viento){
        int resultado = 0;
        conexion.conectar();
        String consulta = "update vientos set velocidad = ?, direccion = ? where idviento = ?";
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(consulta);
            preparedStatement.setInt(1, viento.getVelocidad());
            preparedStatement.setString(2, viento.getDireccion());
            preparedStatement.setInt(3, viento.getIdViento());
            resultado = conexion.executeNonQuery(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public int deleteViento(Viento viento){
        int resultado = 0;
        conexion.conectar();
        String consulta = "delete from vientos where idviento = ?";
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(consulta);
            preparedStatement.setInt(1, viento.getIdViento());
            resultado = conexion.executeNonQuery(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}

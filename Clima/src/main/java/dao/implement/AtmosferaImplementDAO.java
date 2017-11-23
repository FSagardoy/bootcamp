package dao.implement;

import com.franciscosagardoy.Atmosfera;
import dao.interfaz.AtmosferaDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtmosferaImplementDAO implements AtmosferaDAO {
    private GestorDAO conexion;

    public AtmosferaImplementDAO(){
        this.conexion = GestorDAO.getInstancia();
    }

    public int insertAtmosfera(Atmosfera atmosfera){
        int resultado = 0;
        conexion.conectar();
        String consulta = "insert into atmosferas (humedad, presion, visibilidad, ambiente_asc) values (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(consulta);
            preparedStatement.setInt(1, atmosfera.getHumedad());
            preparedStatement.setDouble(2, atmosfera.getPresion());
            preparedStatement.setInt(3, atmosfera.getVisibilidad());
            preparedStatement.setInt(4, atmosfera.getAmbienteAscendente());
            resultado = conexion.executeNonQuery(preparedStatement);
//            conexion.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public int updateAtmosfera(Atmosfera atmosfera){
        int resultado = 0;
        conexion.conectar();
        String consulta = "update atmosferas set humedad = ?, presion = ?, visibilidad = ?, ambiente_asc = ? where idatmosfera = ?";
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(consulta);
            preparedStatement.setInt(1, atmosfera.getHumedad());
            preparedStatement.setDouble(2, atmosfera.getPresion());
            preparedStatement.setInt(3, atmosfera.getVisibilidad());
            preparedStatement.setInt(4, atmosfera.getAmbienteAscendente());
            preparedStatement.setInt(5, atmosfera.getIdAtmosfera());
            resultado = conexion.executeNonQuery(preparedStatement);
//            conexion.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public int deleteAtmosfera(Atmosfera atmosfera){
        int resultado = 0;
        conexion.conectar();
        String consulta = "delete from atmosferas where idatmosfera = ?";
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(consulta);
            preparedStatement.setInt(1, atmosfera.getHumedad());
            resultado = conexion.executeNonQuery(preparedStatement);
//            conexion.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}

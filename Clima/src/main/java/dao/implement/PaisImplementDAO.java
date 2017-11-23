package dao.implement;


import com.franciscosagardoy.Pais;
import dao.interfaz.PaisDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaisImplementDAO implements PaisDAO {
    private GestorDAO conexion;

    public PaisImplementDAO(){
        this.conexion = GestorDAO.getInstancia();
    }

    public int insertPais(Pais pais){
        int resultado = 0;
        conexion.conectar();
        String consulta = "insert into paises (cod_alfa3, cod_alfa2, nombre) values (?,?,?)";
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(consulta);
            preparedStatement.setString(1,pais.getCodAlfa3());
            preparedStatement.setString(2, pais.getCodAlfa2());
            preparedStatement.setString(3,pais.getNombre());
            resultado = conexion.executeNonQuery(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public int updatePais(Pais pais){
        int resultado = 0;
        conexion.conectar();
        String consulta = "update paises set cod_alfa3 = ?, cod_alfa2 = ?, nombre = ? where idpais = ?";
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(consulta);
            preparedStatement.setString(1, pais.getCodAlfa3());
            preparedStatement.setString(2, pais.getCodAlfa2());
            preparedStatement.setString(3, pais.getNombre());
            preparedStatement.setInt(4, pais.getIdPais());
            resultado = conexion.executeNonQuery(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public int deletePais(Pais pais){
        int resultado = 0;
        conexion.conectar();
        String consulta = "delete from paises where idpais = ?";
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(consulta);
            preparedStatement.setInt(1, pais.getIdPais());
            resultado = conexion.executeNonQuery(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }


    public ArrayList<Pais> getPaises() {
        conexion.conectar();
        ArrayList<Pais> resultado = new ArrayList<Pais>();
        String consulta = "select * from paises";
        try {
            PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(consulta);
            ResultSet res = conexion.executeQuery(preparedStatement);
            while (res.next()){
                Pais pais = new Pais();
                pais.setIdPais(res.getInt(1));
                pais.setCodAlfa3(res.getString(2));
                pais.setCodAlfa2(res.getString(3));
                pais.setNombre(res.getString(4));
                resultado.add(pais);
            }
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}

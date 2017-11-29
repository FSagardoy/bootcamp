package dao.implement;


import com.franciscosagardoy.Pais;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PaisImplementDAO extends ImplementDAO{

    public PaisImplementDAO(){}

    public int insert(Object object){
        Pais pais = (Pais) object;
        int resultado = 0;
        getGestor().conectar();
        String consulta = "insert into paises (cod_alfa3, cod_alfa2, nombre) values (?,?,?)";
        try {
            PreparedStatement preparedStatement = getGestor().getConnection().prepareStatement(consulta);
            preparedStatement.setString(1,pais.getCodAlfa3());
            preparedStatement.setString(2, pais.getCodAlfa2());
            preparedStatement.setString(3,pais.getNombre());
            resultado = executeNonQuery(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public int update(Object object){
        Pais pais = (Pais) object;
        int resultado = 0;
        getGestor().conectar();
        String consulta = "update paises set cod_alfa3 = ?, cod_alfa2 = ?, nombre = ? where idpais = ?";
        try {
            PreparedStatement preparedStatement = getGestor().getConnection().prepareStatement(consulta);
            preparedStatement.setString(1, pais.getCodAlfa3());
            preparedStatement.setString(2, pais.getCodAlfa2());
            preparedStatement.setString(3, pais.getNombre());
            preparedStatement.setInt(4, pais.getIdPais());
            resultado = executeNonQuery(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public int delete(Object object){
        Pais pais = (Pais) object;
        int resultado = 0;
        getGestor().conectar();
        String consulta = "delete from paises where idpais = ?";
        try {
            PreparedStatement preparedStatement = getGestor().getConnection().prepareStatement(consulta);
            preparedStatement.setInt(1, pais.getIdPais());
            resultado = executeNonQuery(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }


    public ArrayList<Object> select() {
        getGestor().conectar();
        ArrayList<Object> resultado = new ArrayList<Object>();
        String consulta = "select * from paises";
        try {
            Statement st = getGestor().getConnection().createStatement();
            ResultSet res = st.executeQuery(consulta);
            while (res.next()){
                Pais pais = new Pais();
                pais.setIdPais(res.getInt(1));
                pais.setCodAlfa3(res.getString(2));
                pais.setCodAlfa2(res.getString(3));
                pais.setNombre(res.getString(4));
                resultado.add(pais);
            }
            res.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}

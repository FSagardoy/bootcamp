package dao.interfaz;

import com.franciscosagardoy.Pais;
import com.franciscosagardoy.Provincia;

import java.sql.PreparedStatement;
import java.util.ArrayList;

public interface ProvinciaDAO {
    int insertProvincia(Provincia provincia);

    int updateProvincia(Provincia provincia);

    int deleteProvincia(Provincia provincia);

    ArrayList<Provincia> getProvincias();
}

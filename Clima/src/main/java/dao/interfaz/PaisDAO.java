package dao.interfaz;

import com.franciscosagardoy.Atmosfera;
import com.franciscosagardoy.Clima;
import com.franciscosagardoy.Pais;

import java.util.ArrayList;

public interface PaisDAO {
    int insertPais(Pais pais);

    int updatePais(Pais pais);

    int deletePais(Pais pais);

    ArrayList<Pais> getPaises();
}

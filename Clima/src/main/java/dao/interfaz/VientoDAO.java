package dao.interfaz;

import com.franciscosagardoy.Atmosfera;
import com.franciscosagardoy.Viento;

public interface VientoDAO {
    int insertViento(Viento viento);

    int updateViento(Viento viento);

    int deleteViento(Viento viento);
}

package dao.interfaz;

import com.franciscosagardoy.Clima;

import java.util.ArrayList;

public interface ClimaDAO {
    int insertClima(Clima clima);

    int deleteClima(Clima clima);

    int updateClima(Clima clima);

    ArrayList<Clima> getClima();
}

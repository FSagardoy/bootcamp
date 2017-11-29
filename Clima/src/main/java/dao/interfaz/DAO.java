package dao.interfaz;

import java.util.ArrayList;

public interface DAO {

    int insert(Object object);

    int update(Object object);

    int delete(Object object);

    ArrayList<Object> select();

}

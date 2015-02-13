package dataAccess.interfaces;

import java.util.List;

/**
 * Created by Arnaud on 13/02/2015.
 */
public interface Dao<T> {

    public void create(T obj);

    public void update(T obj);

    public T read(int id);

    public void delete(int id);

    public List<T> readAll();
}

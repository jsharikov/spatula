package spatula.dao.reference;

import java.util.List;

public interface Dao<T, K> {

    void create(T type);

    T read(K key);

    void update(T type);

    void delete(K key);

    List<T> findAll();

}

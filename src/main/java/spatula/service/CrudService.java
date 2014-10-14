package spatula.service;

import java.util.List;

public interface CrudService<T, K> {

    void save(T entity);

    T get(K id);

    void delete(K id);

    List<T> getAll();

}

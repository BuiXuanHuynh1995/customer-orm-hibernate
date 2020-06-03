package respository;

import java.util.List;

public interface IRepositoty<T> {
    List<T> findAll();
    T findById(Long id);
    void saveOrUpdate(T model);
    void delete(Long id);
}

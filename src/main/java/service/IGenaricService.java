package service;

import java.util.List;

public interface IGenaricService<T> {
    List<T> findAll();
    T findById(Long id);
    void saveOrUpdate(T model);
    void delete(Long id);
}

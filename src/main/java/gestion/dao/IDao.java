package gestion.dao;

import java.util.List;

public interface IDao<T> {


        boolean saveOrUpdate(T f);
        boolean create(T f);
        boolean update(T f);
        boolean delete(T f);
        T getById(int id);
        List<T> getAll();
        List<String> getAllFields();
}

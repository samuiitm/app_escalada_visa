package Model.Interfaces;

import java.util.List;

public interface DAO<T> {
    void insertar(T obj);
    T obtener(int id);
    List<T> obtenerTodos();
    void actualizar(T obj);
    void eliminar(int id);
}

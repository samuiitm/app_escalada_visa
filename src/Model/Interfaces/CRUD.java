package Model.Interfaces;

import java.util.List;

public interface CRUD<T> {
    void inserir(T obj);
    T obtenir(int id);
    List<T> obtenirTots();
    void actualitzar(T obj);
    void eliminar(int id);
    int obtenirPerNom(String nom);
}

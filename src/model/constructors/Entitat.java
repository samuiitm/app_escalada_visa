package model.constructors;

public abstract class Entitat {
    protected int id;

    public Entitat(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
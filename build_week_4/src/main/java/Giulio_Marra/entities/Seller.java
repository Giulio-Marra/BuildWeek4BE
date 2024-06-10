package Giulio_Marra.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Seller {
    @GeneratedValue
    @Id
    @OneToMany
    private long id;
    private String name;
    private boolean state;



    public Seller () {}

    public Seller(String name, boolean state) {
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

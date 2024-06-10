package Giulio_Marra.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("automatic_seller")
public class Automatic_seller extends Seller {

    private boolean state;

    public Automatic_seller() {

    }

    public Automatic_seller(String name, boolean state) {
        super(name);
        this.state = state;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Automatic_seller{" +
                "state=" + state +
                '}';
    }
}

package fairyShop.models;

import fairyShop.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseHelper implements Helper {
    private String name;
    private int energy;
    private Collection<Instrument> instruments = new ArrayList<>();

    public BaseHelper(String name, int energy) {
        setName(name);
        setEnergy(energy);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.equals("")) {
            throw new NullPointerException(ExceptionMessages.HELPER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public Collection<Instrument> getInstruments() {
        return instruments;
    }

    public int getEnergy() {
        return energy;
    }

    private void setEnergy(int energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    public void work() {
        if (this.energy - 10 < 0) {
            this.energy = 0;
        } else {
            this.energy -= 10;
        }
    }

    public void addInstrument(Instrument instrument) {
        this.instruments.add(instrument);
    }

    public boolean canWork() {
        return !(this.energy == 0);
    }
}

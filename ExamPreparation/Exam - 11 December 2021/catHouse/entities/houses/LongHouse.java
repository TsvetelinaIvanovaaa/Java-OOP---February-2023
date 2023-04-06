package catHouse.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.Collection;

public class LongHouse extends BaseHouse{

    private static final int LONG_HOUSE_CAPACITY = 30;

    public LongHouse(String name) {
        super(name, LONG_HOUSE_CAPACITY);
    }

    public LongHouse(String name, int capacity) {
        super(name, capacity);
    }

    @Override
    public int sumSoftness() {
        return super.sumSoftness();
    }

    @Override
    public void addCat(Cat cat) {
        super.addCat(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        super.removeCat(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        super.buyToy(toy);
    }

    @Override
    public void feeding() {
        super.feeding();
    }

    @Override
    public String getStatistics() {
        return super.getStatistics();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public Collection<Cat> getCats() {
        return super.getCats();
    }

    @Override
    public Collection<Toy> getToys() {
        return super.getToys();
    }
}

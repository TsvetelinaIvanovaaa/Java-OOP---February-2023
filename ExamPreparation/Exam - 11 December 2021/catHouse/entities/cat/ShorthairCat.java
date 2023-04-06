package catHouse.entities.cat;

public class ShorthairCat extends BaseCat{

    private static final int SHORT_HAIR_CAT_KILOGRAMS = 7;

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, SHORT_HAIR_CAT_KILOGRAMS, price);
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
    public int getKilograms() {
        return super.getKilograms();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public void eating() {
        this.setKilograms(this.getKilograms() + 1);
    }

    @Override
    public void setBreed(String breed) {
        super.setBreed(breed);
    }

    @Override
    public void setKilograms(int kilograms) {
        super.setKilograms(kilograms);
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }
}

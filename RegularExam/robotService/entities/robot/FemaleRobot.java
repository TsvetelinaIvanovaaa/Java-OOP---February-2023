package robotService.entities.robot;

public class FemaleRobot extends BaseRobot{

    private static final int KILOGRAMS = 7;

    public FemaleRobot(String name, String kind, double price) {
        super(name, kind, KILOGRAMS, price);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setKind(String kind) {
        super.setKind(kind);
    }

    @Override
    public void setKilograms(int kilograms) {
        super.setKilograms(kilograms);
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }

    @Override
    public String getName() {
        return super.getName();
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
        int newKilograms = super.getKilograms() + 1;
        super.setKilograms(newKilograms);
    }
}

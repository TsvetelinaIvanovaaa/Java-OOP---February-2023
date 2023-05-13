package fairyShop.models;

public class Sleepy extends BaseHelper {
    private int energy;
    public Sleepy(String name) {
        super(name, 50);
    }

    @Override
    public void work() {
        if (this.energy - 15 < 0) {
            this.energy = 0;
        } else {
            this.energy -= 15;
        }
    }
}

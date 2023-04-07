package christmasPastryShop.entities.delicacies;

public class Gingerbread extends BaseDelicacy{

    private static final double INITIAL_GINDER_BREAD_PORTION = 200;

    public Gingerbread(String name, double price) {
        super(name, INITIAL_GINDER_BREAD_PORTION, price);
    }

}

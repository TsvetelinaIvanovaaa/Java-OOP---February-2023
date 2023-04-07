package christmasPastryShop.entities.booths;

public class OpenBooth extends BaseBooth{

    private static final double OPEN_BOOT_PRICE_PER_PERSON = 2.50;

    public OpenBooth(int boothNumber, int capacity) {
        super(boothNumber, capacity, OPEN_BOOT_PRICE_PER_PERSON);
    }
}

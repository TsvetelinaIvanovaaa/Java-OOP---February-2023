package christmasPastryShop.entities.booths;

public class PrivateBooth extends BaseBooth{

    private static final double PRIVATE_BOOT_PRICE_PER_PERSON = 3.50;

    public PrivateBooth(int boothNumber, int capacity) {
        super(boothNumber, capacity, PRIVATE_BOOT_PRICE_PER_PERSON);
    }
}

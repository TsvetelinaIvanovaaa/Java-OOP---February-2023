package WorkingWithAbstraction.HotelReservation;

public enum DiscountType {
    VIP(0.8),
    SECOND_VISIT(0.9),
    NONE(1);

    private double priceReducer;

    DiscountType(double priceReducer) {
        this.priceReducer = priceReducer;
    }

    public static DiscountType parse(String s) {
        switch (s){
            case "VIP":
                return DiscountType.valueOf(s);
            case "SecondVisit":
                return DiscountType.valueOf("SECOND_VISIT");
            case "None":
                return DiscountType.valueOf(s.toUpperCase());
            default:
                throw new IllegalArgumentException("Unknown type of Discount!");

        }

    }

    public double getPriceReducer() {
        return this.priceReducer;
    }
}

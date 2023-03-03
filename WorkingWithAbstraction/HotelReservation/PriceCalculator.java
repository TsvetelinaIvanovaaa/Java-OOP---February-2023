package WorkingWithAbstraction.HotelReservation;

public class PriceCalculator {

    //price per day, number of days, the season, and a discount type.
    private double pricePerDay;
    private int numbersOfDays;
    Season season;
    DiscountType discount;

    public PriceCalculator(double pricePerDay, int numbersOfDays, Season season, DiscountType discount) {
        this.pricePerDay = pricePerDay;
        this.numbersOfDays = numbersOfDays;
        this.season = season;
        this.discount = discount;
    }

    public double getPricePerHoliday() {
        return pricePerDay * numbersOfDays * season.getMultiplier() * discount.getPriceReducer();
    }

}

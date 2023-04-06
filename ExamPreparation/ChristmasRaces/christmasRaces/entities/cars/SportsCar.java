package christmasRaces.entities.cars;

import christmasRaces.common.ExceptionMessages;

public class SportsCar extends BaseCar{
    public static final double SPORT_CAR_CUBIC_CENTIMETERS = 3000;
    public static final int MIN_HORSE_POWER = 250;
    public static final int MAX_HORSE_POWER = 450;

    public SportsCar(String model, int horsePower) {
        super(model, horsePower, SPORT_CAR_CUBIC_CENTIMETERS);
    }

    @Override
    public void checkHorsePower(int horsePower) {
        if (horsePower < MIN_HORSE_POWER || horsePower > MAX_HORSE_POWER) {
            String exceptionMessage = String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower);
        }
    }


}

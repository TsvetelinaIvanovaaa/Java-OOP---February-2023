package christmasRaces.entities.cars;

import christmasRaces.common.ExceptionMessages;

public class MuscleCar extends BaseCar{


    public static final double MUSCLE_CAR_CUBIC_CENTIMETERS = 5000;
    public static final int MIN_HORSE_POWER = 400;
    public static final int MAX_HORSE_POWER = 5000;

    public MuscleCar(String model, int horsePower) {

        super(model, horsePower, MUSCLE_CAR_CUBIC_CENTIMETERS);
    }

    @Override
    public void checkHorsePower (int horsePower) {
        if(horsePower < MIN_HORSE_POWER || horsePower > MAX_HORSE_POWER){
            String exceptionMessage = String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower);
        }
    }



}

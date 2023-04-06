package christmasRaces.entities.cars;

import christmasRaces.common.ExceptionMessages;

public abstract class BaseCar implements Car{
    private String model;
    private int horsePower;
    private double cubicCentimeters;

    public BaseCar(String model, int horsePower, double cubicCentimeters) {
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.setCubicCentimeters(cubicCentimeters);
    }

    public void setModel(String model) {
        if(this.model == null || model.trim().length() < 4){
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_MODEL,model, 4));
        }
        this.model = model;
    }

    abstract public void checkHorsePower(int horsePower);
    private void setHorsePower(int horsePower) {
        this.checkHorsePower(horsePower);
        this.horsePower = horsePower;
    }

    private void setCubicCentimeters(double cubicCentimeters) {
        this.cubicCentimeters = cubicCentimeters;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return cubicCentimeters / horsePower * laps;
    }
}

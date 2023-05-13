package fairyShop.models;

import fairyShop.common.ExceptionMessages;

public class InstrumentImpl implements Instrument {
    private int power;

    public InstrumentImpl(int power) {
        setPower(power);
    }

    private void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }

    public void use() {
        if (this.power - 10 < 0) {
            this.power = 0;
        } else {
            this.power -= 10;
        }
    }

    public boolean isBroken() {
        return this.power == 0;
    }
}

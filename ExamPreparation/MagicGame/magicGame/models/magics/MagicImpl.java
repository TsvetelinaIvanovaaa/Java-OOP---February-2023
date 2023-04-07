package magicGame.models.magics;

import magicGame.common.ExceptionMessages;

public abstract class MagicImpl implements Magic{
    private String name;
    private int bulletsCount;

    public MagicImpl(String name, int bulletsCount) {
        this.setName(name);
        this.setBulletsCount(bulletsCount);
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(String.format(ExceptionMessages.INVALID_MAGIC));
        }
        this.name = name;
    }

    public void setBulletsCount(int bulletsCount) {
        if(bulletsCount == 0){
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_MAGIC_BULLETS_COUNT));
        }
        this.bulletsCount = bulletsCount;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsCount() {
        return this.bulletsCount;
    }

    @Override
    public abstract int fire();
}

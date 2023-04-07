package magicGame.models.magics;

public class BlackMagic extends MagicImpl{

    public BlackMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setBulletsCount(int bulletsCount) {
        super.setBulletsCount(bulletsCount);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getBulletsCount() {
        return super.getBulletsCount();
    }

    @Override
    public int fire() {
        if(this.getBulletsCount() < 10){
            return 0;
        }
        this.setBulletsCount(this.getBulletsCount() - 10);
        return this.getBulletsCount();
    }
}

package magicGame.models.magics;

public class RedMagic extends MagicImpl{

    public RedMagic(String name, int bulletsCount) {
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
        if(this.getBulletsCount() < 1){
            return 0;
        }
        this.setBulletsCount(this.getBulletsCount() - 1);
        return this.getBulletsCount();
    }
}

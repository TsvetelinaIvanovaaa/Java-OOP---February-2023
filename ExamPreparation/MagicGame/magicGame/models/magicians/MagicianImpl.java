package magicGame.models.magicians;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.Magic;

public abstract class MagicianImpl implements Magician {

    private String username;
    private int health;
    private int protection;
    private boolean isAlive;
    private Magic magic;

    public MagicianImpl(String username, int health, int protection, Magic magic) {
        this.setUsername(username);
        this.setHealth(health);
        this.setProtection(protection);
        this.setMagic(magic);
        this.setAlive();
    }

    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(String.format(ExceptionMessages.INVALID_MAGICIAN_NAME));
        }
        this.username = username;
    }

    public void setHealth(int health) {
        if (health == 0) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_MAGICIAN_HEALTH));
        }
        this.health = health;
    }

    public void setProtection(int protection) {
        if (protection == 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }

    public void setAlive() {
        if (health > 0) {
            isAlive = true;
        }else{
            isAlive = false;
        }
    }

    public void setMagic(Magic magic) {
        if (magic == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC_NAME);
        }
        this.magic = magic;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getProtection() {
        return this.protection;
    }

    @Override
    public Magic getMagic() {
        return this.magic;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void takeDamage(int points) {
        if (getProtection() > points) {
            setProtection(getProtection() - points);
        } else {
            int rest = points - getProtection();
            if (getHealth() > rest) {
                setHealth(getHealth() - rest);
            }
            setProtection(0);
            setHealth(0);
            setAlive();
        }
    }
}

public abstract class Goddess {
    private int HP;

    protected Goddess() {
        this.HP = 100;
    }

    public int getHP() {
        return HP;
    }

    //@pre 0 <= HP <= 100
    //@post this.HP == HP
    public void setHP(int HP) {
        this.HP = HP;
    }

    //@pre 0 <= damage
    //@post this.HP == this.HP - damage
    public void takeDamage(int damage) {
        this.HP -= damage;
    }

    public abstract int getAttackDamage();

    public boolean isDefeated() {
        return HP <= 0;
    }
}

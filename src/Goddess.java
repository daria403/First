public class Goddess {
    private int HP;
    private int resource;

    public Goddess() {
        this.HP = 100;
        this.resource = 5;
    }
 
    public int getHP() {
        return HP;
    }

    public void setHP(int HP){
    if (0 <= HP && HP <= 100) {
            this.HP = HP;
        } else {
        System.out.println("HP must be between 0 and 100.");
        }
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        if (0 <= resource && resource <= 10) {
            this.resource = resource;
        } else {
            System.out.println("Resource must be between 0 and 10.");
        }
        this.resource = resource;
    }
    public boolean isDefeated() {
        return HP <= 0;
    }
}

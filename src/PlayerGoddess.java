public class PlayerGoddess extends Goddess {
    private int resource;

    public PlayerGoddess() {
        this.resource = 5;
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
    }

    @Override
    public int getAttackDamage() {
        return 10;
    }
}

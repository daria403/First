public class GoddessGame {
    private Goddess MoonGoddess;
    private Goddess SunGoddess;

    public GoddessGame() {
        this.MoonGoddess = new Goddess();
        this.SunGoddess = new Goddess();
    }
    public void GameStatus() {
        System.out.println("Moon Goddess HP: " + MoonGoddess.getHP() + ", Resource: " + MoonGoddess.getResource());
        System.out.println("Sun Goddess HP: " + SunGoddess.getHP() + ", Resource: " + SunGoddess.getResource());
    }
    public boolean Attak(int damage) {
        SunGoddess.setHP(SunGoddess.getHP() - damage);
        System.out.println("You attacked sun goddess for " + damage + " damage!");
        if (SunGoddess.getHP() <= 0) {
            System.out.println();   
            System.out.println("Sun goddess has been defeated (You win!)");
            return true;
        } else {
            GameStatus();
        }
        return CounterAttack(10);
    }
    public boolean CounterAttack(int damage) {
        MoonGoddess.setHP(MoonGoddess.getHP() - damage);
        System.out.println();
        System.out.println("Sun goddess Counter-attacked you for " + damage + " damage!");
        if (MoonGoddess.isDefeated()) {
            System.out.println();
            System.out.println("Moon goddess has been defeated (You lose!)");
            return true;
        } else {
            GameStatus();
        }
        return false;
    }
    public boolean SpecialAttack() {
        if (MoonGoddess.getResource() >= 3) {
            MoonGoddess.setResource(MoonGoddess.getResource() - 3);
            System.out.println("Performing special attack!");
            System.out.println();
            return Attak(15);
        } else {
            System.out.println("You don't have enough resources for special attack!");
            return false;
        }
    }
    public boolean defend() {
        System.out.println("Defending against the next attack!");
        System.out.println();
        return CounterAttack(5);
    }
    public boolean recover() {
        System.out.println("Recovering resources!");
        System.out.println();
        int NewResource = MoonGoddess.getResource() + 3;
        if (NewResource > 10) {
            NewResource = 10;
        }
        MoonGoddess.setResource(NewResource);
        return CounterAttack(10);
    }

}

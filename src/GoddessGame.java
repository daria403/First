public class GoddessGame {
    private final PlayerGoddess player;
    private final EnemyGoddess enemy;

    public GoddessGame() {
        this.player = new PlayerGoddess();
        this.enemy = new EnemyGoddess();
    }

    //@pre 0 <= HP <= 100
    //@post this.player.HP == HP
    public void setPlayerHP(int HP) {
        player.setHP(HP);
    }

    //@pre 0 <= resource <= 10
    //@post this.player.Resource == resource
    public void setPlayerResource(int resource) {
        player.setResource(resource);
    }

    public int getPlayerHP() {
        return player.getHP();
    }

    public int getPlayerResource() {
        return player.getResource();
    }

    public int getEnemyHP() {
        return enemy.getHP();
    }

    public void gameStatus() {
        System.out.println("Player HP: " + player.getHP() + ", Resource: " + player.getResource());
        System.out.println("Enemy HP: " + enemy.getHP());
    }

    public int attack() {
        return attack(player.getAttackDamage());
    }

    private int attack(int damage) {
        enemy.takeDamage(damage);
        System.out.println("You attacked the enemy for " + damage + " damage!");
        if (enemy.isDefeated()) {
            System.out.println();
            System.out.println("The enemy has been defeated (You win!)");
            return 1;
        }
        gameStatus();
        return counterAttack(enemy.getAttackDamage());
    }

    public int counterAttack(int damage) {
        player.takeDamage(damage);
        System.out.println();
        System.out.println("The enemy counter-attacked you for " + damage + " damage!");
        if (player.isDefeated()) {
            System.out.println();
            System.out.println("You have been defeated (You lose!)");
            return 2;
        }
        gameStatus();
        return 0;
    }

    public int specialAttack() {
        if (player.getResource() >= 3) {
            player.setResource(player.getResource() - 3);
            System.out.println("Performing special attack!");
            System.out.println();
            return attack(15);
        }
        System.out.println("You don't have enough resources for special attack!");
        return 0;
    }

    public int defend() {
        System.out.println("Defending against the next attack!");
        System.out.println();
        return counterAttack(Math.max(0, enemy.getAttackDamage() - 5));
    }

    public int recover() {
        System.out.println("Recovering resources!");
        System.out.println();
        player.setResource(Math.min(10, player.getResource() + 3));
        return counterAttack(enemy.getAttackDamage());
    }
}

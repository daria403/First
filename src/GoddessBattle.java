import java.util.Scanner; 

public class GoddessBattle {
    private static class BattleResult {
        private final boolean won;
        private final int playerHP;
        private final int playerResource;

        //@pre (0 <= playerHP <= 100) && (0 <= playerResource <= 10)
        //@post (this.won == won) && (this.playerHP == playerHP) && (this.playerResource == playerResource)
        private BattleResult(boolean won, int playerHP, int playerResource) {
            this.won = won;
            this.playerHP = playerHP;
            this.playerResource = playerResource;
        }
        public boolean isWon() {
            return won;
        }
        public int getPlayerHP() {
            return playerHP;
        }
        public int getPlayerResource() {
            return playerResource;
        }
    }

    //@pre (0 <= PlayerHP <= 100) && (0 <= PlayerResource <= 10)
    //@post (result.won ⟺ the enemy was defeated) && (result.playerHP == player's remaining HP) && (result.playerResource == player's remaining resource)
    private static BattleResult startBattle(Scanner scanner, int PlayerHP, int PlayerResource,int EnemyHP,boolean PlayerPower) {
        GoddessGame game = new GoddessGame();
        game.setPlayerHP(PlayerHP);
        game.setPlayerResource(PlayerResource);
        game.setEnemyHP(EnemyHP);
        String[] WinnerArr = new String[]{"You have defeated the enemy! You win!", "You have been defeated by the enemy! You lose!"};

        while (true){
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Choose an action: 1. Attack 2. Special Attack 3. Defend 4. Recover 5. Exit");
            int choice = scanner.nextInt();
            int status = 0;
            if (choice == 1) {
                if (PlayerPower){
                    status = game.attack(12);
                }else{
                    status = game.attack();
                }
            }
            else if (choice == 2) {
                status= game.specialAttack();
            }
            else if (choice == 3) {
                status = game.defend();
            }
            else if (choice == 4) {
                status = game.recover();
            }
            else if (choice == 5) {
                System.out.println("Exiting the game.");
                status = 2;
            }
            else {
                System.out.println("Invalid choice. Please try again.");
            }
            if (status == 1 || status == 2) {
                System.out.println(WinnerArr[status - 1]);
                System.out.println("Game Over.");
                game.gameStatus();
                System.out.println("--------------------------------------------------------------------------");
                return new BattleResult(
                        status == 1,
                        game.getPlayerHP(),
                        game.getPlayerResource());
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BattleResult firstEncounter = startBattle(scanner, 100, 5, 30,false);
        if (!firstEncounter.isWon()) {
            System.out.println("Encounter 1 was lost. The game ends.");
        }else {
            System.out.println("Encounter 1 won! Starting Encounter 2.");
            boolean PlayerPower = false;
            int newHP = firstEncounter.getPlayerHP();
            while (true) {
                System.out.println("Please choose your prize for winning Encounter 1: 1. Power (Attack Damage +2)  2. Recovery (HP +25)");
                int PrizeChoice = scanner.nextInt();
                if (PrizeChoice == 1) {
                    PlayerPower = true;
                    break; // Valid choice, exit the reward loop
                } else if (PrizeChoice == 2) {
                    newHP = Math.min(100, newHP + 25);
                    break; // Valid choice, exit the reward loop
                } else {
                    System.out.println("Invalid reward choice. Please try again."); //[cite: 14]
                }
            }
            BattleResult secondEncounter = startBattle(
                    scanner,
                    newHP,
                    firstEncounter.getPlayerResource(),
                    45,
                    PlayerPower);
            if (secondEncounter.isWon()) {
                System.out.println("Overall victory! You won both encounters!");
            } else {
                System.out.println("Encounter 2 was lost. The game ends.");
            }
        }

    }
}
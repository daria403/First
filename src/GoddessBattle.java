import java.util.Scanner; 

public class GoddessBattle {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Welcome to the Goddess Battle Game!");
        System.out.println("You are the Moon Goddess, and you will battle against the Sun Goddess.");
        System.out.println("Both goddesses start with 100 HP and 5 resources.");
        System.out.println("You can perform the following actions:");
        System.out.println("1. Attack (10 damage)");
        System.out.println("2. Special Attack (15 damage, costs 3 resources)");
        System.out.println("3. Defend (reduces incoming damage by 5)");
        System.out.println("4. Recover (restores 3 resources, max 10)");
        System.out.println("5. Exit the game (and lose)");
        System.out.println("The game ends when either goddess's HP reaches 0.");
        System.out.println("Good luck!");

        GoddessGame game = new GoddessGame();
        boolean GameEnd = false;
        while (!GameEnd){
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Choose an action: 1. Attack 2. Special Attack 3. Defend 4. Recover 5. Exit");
            int choice = scanner.nextInt();
            if (choice == 1) {
                GameEnd = game.Attak(10);
            }
            else if (choice == 2) {
                GameEnd = game.SpecialAttack();
            }
            else if (choice == 3) {
                GameEnd = game.defend();
            }
            else if (choice == 4) {
                GameEnd = game.recover();
            }
            else if (choice == 5) {
                System.out.println("Exiting the game.");
                GameEnd = true;
            }
            else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Game Over!");
        scanner.close();
    }
}
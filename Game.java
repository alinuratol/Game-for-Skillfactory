import java.util.Scanner;

public class Game {
    Hero player;
    String currentLocation = "city";
    Merchant merchant = new Merchant();
    Object currentEnemy = null;
    boolean isInBattle = false;

    public void startGame() {
        System.out.println("Welcome to the Adventure Game!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your hero's name: ");
        String playerName = scanner.nextLine();
        player = new Hero(playerName, 5, 100, 0, 10, 5);

        while (true) {
            if ("city".equals(currentLocation)) {
                showCityOptions();
            } else if ("forest".equals(currentLocation)) {
                enterForest();
            }
        }
    }

    public void showCityOptions() {
        System.out.println("\nOptions:");
        System.out.println("1. Go to the merchant");
        System.out.println("2. Enter the dark forest");
        System.out.println("3. Exit");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        if ("1".equals(choice)) {
            visitMerchant();
        } else if ("2".equals(choice)) {
            enterForest();
        } else if ("3".equals(choice)) {
            System.out.println("Goodbye!");
            System.exit(0);
        } else {
            System.out.println("Invalid choice. Please enter a number from the options.");
        }
    }

    public void visitMerchant() {
        if (merchant.inventory.length > 0) {
            System.out.println("Welcome to the merchant's shop!");
            System.out.println("Options:");
            System.out.println("1. Buy a health potion");
            System.out.println("2. Return to the city");

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            if ("1".equals(choice)) {
                merchant.sellPotion(player);
            } else if ("2".equals(choice)) {
                currentLocation = "city";
            } else {
                System.out.println("Invalid choice. Please enter a number from the options.");
            }
        } else {
            System.out.println("The merchant is not working right now. Come back later.");
        }
    }

    public void enterForest() {
        System.out.println("You entered the dark forest.");

        if (!isInBattle) {
            spawnRandomEnemy();
        }

        Battle battle = new Battle(player, currentEnemy);
        Thread battleThread = new Thread(battle);
        battleThread.start();

        if (player.health > 0) {
            afterBattleOptions();
        }
    }

    public void spawnRandomEnemy() {
        if (new Random().nextBoolean()) {
            currentEnemy = new Goblin(30, 5);
        } else {
            currentEnemy = new Skeleton(20, 7);
        }

        System.out.println("A wild " + currentEnemy.getClass().getSimpleName() + " appears!");
    }

    public void afterBattleOptions() {
        System.out.println("\nOptions:");
        System.out.println("1. Return to the city");
        System.out.println("2. Continue exploring the forest");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        if ("1".equals(choice)) {
            currentLocation = "city";
            isInBattle = false;
        } else if ("2".equals(choice)) {
            isInBattle = false;
            enterForest();
        } else {
            System.out.println("Invalid choice. Please enter a number from the options.");
        }
    }
}

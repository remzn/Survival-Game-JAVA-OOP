import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scan = new Scanner(System.in);

    public void login() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Adventure Game!");
        System.out.println("Please enter your name before starting the game:");
        String playerName = scan.nextLine();
        player = new Player(playerName);
        player.selectCharacter();
        start();
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("=================================================");
            System.out.println();
            System.out.println("Choose a place to perform an action:");
            System.out.println("1. Safe House --> Your own safe place, no enemies!");
            System.out.println("2. Cave --> You might encounter a zombie!");
            System.out.println("3. Forest --> You might encounter a vampire!");
            System.out.println("4. River --> You might encounter a bear!");
            System.out.println("5. Tool Store --> You can buy weapons or armor!");
            System.out.print("Where would you like to go: ");
            int selLoc = scan.nextInt();
            while (selLoc < 0 || selLoc > 5) {
                System.out.print("Please choose a valid location: ");
                selLoc = scan.nextInt();
            }

            switch (selLoc) {
            case 1:
                location = new SafeHouse(player);
                break;
            case 2:
                location = new Cave(player);
                break;
            case 3:
                location = new Forest(player);
                break;
            case 4:
                location = new River(player);
                break;
            case 5:
                location = new ToolStore(player);
                break;
            default:
                location = new SafeHouse(player);
            }

            if (location.getClass().getName().equals("SafeHouse")) {
                if (player.getInventory().isFirewood() && player.getInventory().isFood() && player.getInventory().isWater()) {
                    System.out.println("Congratulations, you won the game!");
                    break;
                }
            }
            if (!location.getLocation()) {
                System.out.println("Game Over!");
                break;
            }
        }
    }
}

import java.util.Scanner;

public class Player {
    private int damage, health, money, maxHealth;
    private String name, characterName;
    private Inventory inventory;
    Scanner scan = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    // Method for the player to select a character
    public void selectCharacter() {
        switch (characterMenu()) {
        case 1:
            initializePlayer("Samurai", 5, 21, 15);
            break;
        case 2:
            initializePlayer("Archer", 7, 18, 20);
            break;
        case 3:
            initializePlayer("Knight", 8, 24, 5);
            break;
        default:
            initializePlayer("Samurai", 5, 21, 15);
            break;
        }
        System.out.println("Character created! Name=" + this.characterName + ", Damage=" + this.damage + ", Health=" +
                this.health + ", Money=" + this.money);
    }

    // Menu for character selection
    private int characterMenu() {
        System.out.println("Please select a character: ");
        System.out.println("1- Samurai \t Damage: 5 \t Health: 21 \t Money: 15");
        System.out.println("2- Archer \t Damage: 7 \t Health: 18 \t Money: 20");
        System.out.println("3- Knight \t Damage: 8 \t Health: 24 \t Money: 5");
        System.out.print("Your character choice: ");
        int characterID = scan.nextInt();

        while (characterID < 1 || characterID > 3) {
            System.out.print("Please select a valid character: ");
            characterID = scan.nextInt();
        }

        return characterID;
    }

    // Method to initialize player with chosen character
    private void initializePlayer(String characterName, int damage, int health, int money) {
        this.characterName = characterName;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.maxHealth = health;
    }

    // Total damage calculation including inventory
    public int getTotalDamage() {
        return this.damage + this.inventory.getDamage();
    }

    // Getters and setters for player attributes
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
}

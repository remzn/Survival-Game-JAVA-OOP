import java.util.Scanner;

public abstract class Location {
    protected Player player;
    protected String name;
    Scanner scan = new Scanner(System.in);
    
    Location(Player player) {
        this.player = player;
    }
    
    public abstract boolean getLocation();

    // Get the player object
    public Player getPlayer() {
        return player;
    }

    // Set the player object
    public void setPlayer(Player player) {
        this.player = player;
    }

    // Get the name of the location
    public String getName() {
        return name;
    }

    // Set the name of the location
    public void setName(String name) {
        this.name = name;
    }
}

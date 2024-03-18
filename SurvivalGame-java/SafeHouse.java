public class SafeHouse extends NormalLoc {

    SafeHouse(Player player) {
        super(player, "Safe House");
    }
    
    // Method to describe actions taken when the player is in the safe house
    public boolean getLocation() {
        player.setHealth(player.getMaxHealth());
        System.out.println("You are healed...");
        System.out.println("You are now in the Safe House.");
        return true;
    }
}

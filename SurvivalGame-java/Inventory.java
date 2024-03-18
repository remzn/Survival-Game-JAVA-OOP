public class Inventory {
    private boolean water, food, firewood;
    private String weaponName, armorName;
    private int damage, armor;
    
    Inventory() {
        this.water = false;
        this.food = false;
        this.firewood = false;
        this.damage = 0;
        this.armor = 0;
        this.weaponName = null;
        this.armorName = null;
    }

    // Check if water is present in the inventory
    public boolean isWater() {
        return water;
    }

    // Set the water status in the inventory
    public void setWater(boolean water) {
        this.water = water;
    }

    // Check if food is present in the inventory
    public boolean isFood() {
        return food;
    }

    // Set the food status in the inventory
    public void setFood(boolean food) {
        this.food = food;
    }

    // Check if firewood is present in the inventory
    public boolean isFirewood() {
        return firewood;
    }

    // Set the firewood status in the inventory
    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    // Get the name of the weapon in the inventory
    public String getWeaponName() {
        return weaponName;
    }

    // Set the name of the weapon in the inventory
    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    // Get the name of the armor in the inventory
    public String getArmorName() {
        return armorName;
    }

    // Set the name of the armor in the inventory
    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    // Get the damage value of the inventory
    public int getDamage() {
        return damage;
    }

    // Set the damage value in the inventory
    public void setDamage(int damage) {
        this.damage = damage;
    }

    // Get the armor value of the inventory
    public int getArmor() {
        return armor;
    }

    // Set the armor value in the inventory
    public void setArmor(int armor) {
        this.armor = armor;
    }
}

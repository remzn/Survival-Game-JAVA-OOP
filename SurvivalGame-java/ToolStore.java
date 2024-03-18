public class ToolStore extends NormalLoc {

    ToolStore(Player player) {
        super(player, "Tool Store");
    }

    public boolean getLocation() {
        System.out.println("Money: " + player.getMoney());
        System.out.println("1. Weapons");
        System.out.println("2. Armors");
        System.out.println("3. Exit");
        System.out.print("Your choice: ");
        int selTool = scan.nextInt();
        int selItemID;
        switch (selTool) {
        case 1:
            selItemID = weaponMenu();
            buyWeapon(selItemID);
            break;
        case 2:
            selItemID = armorMenu();
            buyArmor(selItemID);
            break;
        default:
            break;
        }
        return true;
    }

    private int weaponMenu() {
        System.out.println("1. Gun\t<Money: 25 - Damage: 2>");
        System.out.println("2. Sword\t<Money: 35 - Damage: 3>");
        System.out.println("3. Rifle\t<Money: 45 - Damage: 7>");
        System.out.println("4. Exit");
        System.out.print("Select Weapon: ");
        int selWeaponID = scan.nextInt();
        return selWeaponID;
    }

    private void buyWeapon(int itemID) {
        int damage = 0, price = 0;
        String weaponName = null;
        switch (itemID) {
        case 1:
            damage = 2;
            weaponName = "Gun";
            price = 25;
            break;
        case 2:
            damage = 3;
            weaponName = "Sword";
            price = 35;
            break;
        case 3:
            damage = 7;
            weaponName = "Rifle";
            price = 45;
            break;
        case 4:
            System.out.println("Exiting.");
            break;
        default:
            System.out.println("Invalid operation!");
            break;
        }

        if (price > 0) {
            if (player.getMoney() > price) {
                player.getInventory().setDamage(damage);
                player.getInventory().setWeaponName(weaponName);
                player.setMoney(player.getMoney() - price);
                System.out.println("You have purchased " + weaponName + ", Previous Damage: " + player.getDamage() + ", New Damage: "
                        + player.getTotalDamage());
                System.out.println("Remaining Money: " + player.getMoney());
            } else {
                System.out.println("Insufficient funds!");
            }
        }
    }

    private int armorMenu() {
        System.out.println("1. Light \t <Money: 15 - Defense: 1>");
        System.out.println("2. Medium \t <Money: 25 - Defense: 3>");
        System.out.println("3. Heavy \t <Money: 40 - Defense: 5>");
        System.out.println("4. Exit");
        System.out.print("Select Armor: ");
        int selArmorID = scan.nextInt();
        return selArmorID;
    }

    private void buyArmor(int itemID) {
        int defense = 0, price = 0;
        String armorName = null;
        switch (itemID) {
        case 1:
            defense = 1;
            armorName = "Light Armor";
            price = 15;
            break;
        case 2:
            defense = 3;
            armorName = "Medium Armor";
            price = 25;
            break;
        case 3:
            defense = 5;
            armorName = "Heavy Armor";
            price = 40;
            break;
        case 4:
            System.out.println("Exiting.");
            break;
        default:
            System.out.println("Invalid operation!");
            break;
        }

        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInventory().setArmor(defense);
                player.getInventory().setArmorName(armorName);
                player.setMoney(player.getMoney() - price);
                System.out.println(armorName + " purchased, Defense: " + player.getInventory().getArmor());
                System.out.println("Remaining Money: " + player.getMoney());
            } else {
                System.out.println("Insufficient funds!");
            }
        }
    }
}

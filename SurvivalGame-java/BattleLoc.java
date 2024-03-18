public abstract class BattleLoc extends Location {
    protected Obstacle obstacle;
    protected String award;

    BattleLoc(Player player, String name, Obstacle obstacle, String award) {
        super(player);
        this.obstacle = obstacle;
        this.name = name;
        this.award = award;
    }

    public boolean getLocation() {
        int obsCount = obstacle.count();
        System.out.println("You are here: " + this.getName());
        System.out.println("Be careful! There are " + obsCount + " " + obstacle.getName() + "(s) here!");
        System.out.print("<F>ight or <R>un:");
        String selCase = scan.nextLine();
        selCase = selCase.toUpperCase();
        if (selCase.equals("F")) {
            if (combat(obsCount)) {
                System.out.println("You have cleared all enemies in the " + this.getName() + " area!");
                if (this.award.equals("Food") && !player.getInventory().isFood()) {
                    System.out.println("You have gained " + this.award + "!");
                    player.getInventory().setFood(true);
                } else if (this.award.equals("Water") && !player.getInventory().isWater()) {
                    System.out.println("You have gained " + this.award + "!");
                    player.getInventory().setWater(true);
                } else if (this.award.equals("Firewood") && !player.getInventory().isFirewood()) {
                    System.out.println("You have gained " + this.award + "!");
                    player.getInventory().setFirewood(true);
                }
                return true;
            }

            if (player.getHealth() <= 0) {
                System.out.println("You died!");
                return false;
            }

        }
        return true;
    }

    public boolean combat(int obsCount) {
        for (int i = 0; i < obsCount; i++) {
            int defObsHealth = obstacle.getHealth();
            playerStats();
            enemyStats();
            while (player.getHealth() > 0 && obstacle.getHealth() > 0) {
                System.out.print("<A>ttack or <R>un:");
                String selCase = scan.nextLine();
                selCase = selCase.toUpperCase();
                if (selCase.equals("A")) {
                    System.out.println("You attacked!");
                    obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                    afterHit();
                    if (obstacle.getHealth() > 0) {
                        System.out.println();
                        System.out.println("The enemy attacks you!");
                        player.setHealth(player.getHealth() - (obstacle.getDamage() - player.getInventory().getArmor()));
                        afterHit();
                    }
                } else {
                    return false;
                }
            }

            if (obstacle.getHealth() < player.getHealth()) {
                System.out.println("You defeated the enemy!");
                player.setMoney(player.getMoney() + obstacle.getAward());
                System.out.println("Your current money: " + player.getMoney());
                obstacle.setHealth(defObsHealth);
            } else {
                return false;
            }
            System.out.println("-------------------");
        }
        return true;
    }

    public void playerStats() {
        System.out.println("Player Stats\n--------------");
        System.out.println("Health:" + player.getHealth());
        System.out.println("Damage:" + player.getTotalDamage());
        System.out.println("Money:" + player.getMoney());
        if (player.getInventory().getDamage() > 0) {
            System.out.println("Weapon:" + player.getInventory().getWeaponName());
        }
        if (player.getInventory().getArmor() > 0) {
            System.out.println("Armor:" + player.getInventory().getArmorName());
        }
    }

    public void enemyStats() {
        System.out.println("\n" + obstacle.getName() + " Stats\n--------------");
        System.out.println("Health:" + obstacle.getHealth());
        System.out.println("Damage:" + obstacle.getDamage());
        System.out.println("Reward:" + obstacle.getAward());
    }

    public void afterHit() {
        System.out.println("Player Health:" + player.getHealth());
        System.out.println(obstacle.getName() + " Health:" + obstacle.getHealth());
        System.out.println();
    }
}

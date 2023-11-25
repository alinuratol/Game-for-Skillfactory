import java.util.Random;

public class Merchant {
    int[] inventory = {5};  // Initial number of health potions

    public void sellPotion(Hero hero) {
        if (inventory.length > 0 && hero.gold >= 5) {
            hero.gold -= 5;
            hero.health += 20;
            inventory[0] -= 1;
            System.out.println(hero.name + " bought a health potion. Current health: " + hero.health);
        } else if (hero.gold < 5) {
            System.out.println("Not enough gold to buy a health potion.");
        } else {
            System.out.println("Out of stock for health potions.");
        }
    }

    public void restockInventory() {
        int newInventoryCount = new Random().nextInt(10) + 1;  // Randomly restock between 1 and 10 potions
        inventory[0] = newInventoryCount;
        System.out.println("Merchant restocked health potions. New inventory count: " + newInventoryCount);
    }

    public void offerDiscount(Hero hero) {
        // Merchant's logic to offer a discount based on hero's experience
        if (hero.experience >= 50) {
            System.out.println("Merchant offers a 10% discount!");
            hero.gold -= (int) (hero.gold * 0.1);
            System.out.println(hero.name + " paid less for the health potion. Remaining gold: " + hero.gold);
        } else {
            System.out.println("No discount offered. Purchase at regular price.");
        }
    }
}

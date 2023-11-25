import java.util.Random;

public class Hero extends Entity {
    int agility;
    int experience;
    int gold;

    public Hero(String name, int agility, int health, int experience, int gold, int strength) {
        super(name, health, strength);
        this.agility = agility;
        this.experience = experience;
        this.gold = gold;
    }

    public int attack() {
        if (new Random().nextDouble() < 0.1) {  // 10% chance of a critical hit
            return strength * 2;
        }
        return strength;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public void gainExperience(int experience) {
        this.experience += experience;
    }

    public void buyPotion() {
        if (gold >= 5) {
            gold -= 5;
            health += 20;
            System.out.println(name + " bought a health potion. Current health: " + health);
        } else {
            System.out.println("Not enough gold to buy a health potion.");
        }
    }
}

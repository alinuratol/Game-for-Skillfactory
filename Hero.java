import java.util.Random;

public class Hero {
    String name;
    int agility;
    int health;
    int experience;
    int gold;
    int strength;

    public Hero(String name, int agility, int health, int experience, int gold, int strength) {
        this.name = name;
        this.agility = agility;
        this.health = health;
        this.experience = experience;
        this.gold = gold;
        this.strength = strength;
    }

    public int attack() {
        if (Math.random() < 0.1) {  // 10% chance of a critical hit
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

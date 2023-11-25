import java.util.Random;

public class Skeleton extends Entity {
    public Skeleton(int health, int strength) {
        super("Skeleton", health, strength);
    }

    public int attack() {
        return strength;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public void performSpecialMove(Hero hero) {
        // Skeleton's special move logic
        int specialMoveChance = new Random().nextInt(100);
        if (specialMoveChance < 20) {
            System.out.println("The Skeleton performed a special move!");
            hero.takeDamage(strength * 2);
            System.out.println(hero.name + " took extra damage!");
        }
    }
}

public class Goblin extends Entity {
    public Goblin(int health, int strength) {
        super("Goblin", health, strength);
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
}


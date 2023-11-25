public class Goblin {
    int health;
    int strength;

    public Goblin(int health, int strength) {
        this.health = health;
        this.strength = strength;
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

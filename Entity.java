public class Entity {
    String name;
    int health;
    int strength;

    public Entity(String name, int health, int strength) {
        this.name = name;
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

    public void endBattle(Entity winner) {
        // Общая логика завершения битвы для всех существ
    }
}

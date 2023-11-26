import java.util.Random;

public class Battle implements Runnable {
    Hero hero;
    Entity enemy;
    boolean isBattleOver = false;

    public Battle(Hero hero, Entity enemy) {
        this.hero = hero;
        this.enemy = enemy;
    }

    public void attackTurn(Entity attacker, Entity target) {
        if (attacker == hero) {
            System.out.println(hero.name + " attacks " + target.getClass().getSimpleName() + "!");
        } else {
            System.out.println(target.getClass().getSimpleName() + " attacks " + hero.name + "!");
        }

        if (calculateHit(attacker.attack())) {
            int damage = attacker.attack();
            target.takeDamage(damage);

            System.out.println(target.getClass().getSimpleName() + " takes " + damage + " damage.");

            if (target.health == 0) {
                endBattle(attacker);
            }
        } else {
            System.out.println("Attack missed!");
        }
    }
    public boolean calculateHit(int agility) {
        return agility * 3 > new Random().nextInt(100);
    }

    public void endBattle(Object winner) {
        if (winner == hero) {
            System.out.println(hero.name + " wins the battle!");
            hero.gainExperience(10);
            hero.gold += 5;
        } else {
            System.out.println(((Hero) winner).name + " defeats " + hero.name + ". Game over.");
        }

        isBattleOver = true;
    }

    public void startBattle() {
        System.out.println("Battle begins!");

        while (!isBattleOver) {
            try {
                Thread.sleep(1000);  // Simulate time passing
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (new Random().nextBoolean()) {  // Randomly determine who attacks
                attackTurn(hero, enemy);
            } else {
                attackTurn(enemy, hero);
            }
        }
    }

    @Override
    public void run() {
        startBattle();
    }
}

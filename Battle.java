import java.util.Random;

public class Battle implements Runnable {
    Hero hero;
    Object enemy;
    boolean isBattleOver = false;

    public Battle(Hero hero, Object enemy) {
        this.hero = hero;
        this.enemy = enemy;
    }

    public void attackTurn(Object attacker, Object target) {
        if (attacker == hero) {
            System.out.println(hero.name + " attacks " + target.getClass().getSimpleName() + "!");
        } else {
            System.out.println(target.getClass().getSimpleName() + " attacks " + hero.name + "!");
        }

        if (calculateHit(((Hero) attacker).agility)) {
            int damage = ((Hero) attacker).attack();
            if (target instanceof Goblin) {
                ((Goblin) target).takeDamage(damage);
            } else if (target instanceof Skeleton) {
                ((Skeleton) target).takeDamage(damage);
                ((Skeleton) target).performSpecialMove(hero);
            }

            System.out.println(target.getClass().getSimpleName() + " takes " + damage + " damage.");

            if (target instanceof Goblin && ((Goblin) target).health == 0) {
                endBattle(attacker);
            } else if (target instanceof Skeleton && ((Skeleton) target).health == 0) {
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

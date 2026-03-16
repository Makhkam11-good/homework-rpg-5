package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

import java.util.Random;

public class BattleService {
    private static BattleService instance;
    private Random random = new Random(1L);

    private BattleService() {
    }

    public static BattleService getInstance() {
        if (instance == null) {
            instance = new BattleService();
        }
        return instance;
    }
    public BattleService setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public int getRandomInt(int bound) {
        return random.nextInt(bound);
    }

    public AdventureResult battle(HeroProfile hero, BossEnemy enemy, AttackAction action) {
        AdventureResult result = new AdventureResult();
        int round = 1;

        result.addLine("=== Battle Start ===");

        while (hero.isAlive() && enemy.isAlive()) {
            result.addLine("--- Round " + round + " ---");
            if (random.nextInt(100) < 20) { 
            result.addLine(enemy.getName() + " dodged the hero's attack");
        } else {
            int heroDmg = action.getDamage();
            if (random.nextInt(100) < 10) { 
                heroDmg *= 2;
                result.addLine("CRITICAL HIT by " + hero.getName() + "!");
            }
            enemy.takeDamage(heroDmg);
            result.addLine(hero.getName() + " deals " + heroDmg + " damage.");
        }

        if (!enemy.isAlive()) {
            result.setWinner(hero.getName());
            result.addLine(enemy.getName() + " has been slain");
            break;
        }

    
        if (random.nextInt(100) < 20) { 
            result.addLine(hero.getName() + " dodged the enemy's strike");
        } else {
            int enemyDmg = enemy.getAttackPower();
            if (random.nextInt(100) < 10) { 
                enemyDmg *= 2;
                result.addLine("CRITICAL HIT by " + enemy.getName() + "!");
            }
            hero.takeDamage(enemyDmg);
            result.addLine(enemy.getName() + " hits for " + enemyDmg + " damage.");
        }

        if (!hero.isAlive()) {
            result.setWinner(enemy.getName());
            result.addLine(hero.getName() + " has been fallen");
            break;
        }
            round++;
        }

        result.setRounds(round);
        return result;
    }
}
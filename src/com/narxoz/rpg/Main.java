package com.narxoz.rpg;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.decorator.BasicAttack;
import com.narxoz.rpg.decorator.CriticalFocusDecorator;
import com.narxoz.rpg.decorator.FireRuneDecorator;
import com.narxoz.rpg.decorator.PoisonCoatingDecorator;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.facade.AdventureResult;
import com.narxoz.rpg.facade.DungeonFacade;
import com.narxoz.rpg.facade.GameLogger;
import com.narxoz.rpg.hero.HeroProfile;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Homework 5 Demo: Decorator + Facade ===\n");

        HeroProfile hero = new HeroProfile("Aragorn", 100);
        BossEnemy boss = new BossEnemy("Witch-king", 150, 12);

        AttackAction basicStrike = new BasicAttack("Sword Strike", 10);
        AttackAction fireCritAttack = new FireRuneDecorator(new CriticalFocusDecorator(basicStrike));
        AttackAction ultimateAttack = new PoisonCoatingDecorator(new FireRuneDecorator(new CriticalFocusDecorator(basicStrike)));

        System.out.println("--- Decorator Proof ---");
        GameLogger.logAttackDetails("Base", basicStrike);
        GameLogger.logAttackDetails("Fire + Crit", fireCritAttack);
        GameLogger.logAttackDetails("Ultimate Combo", ultimateAttack);

        System.out.println("\n--- Facade Dungeon Run ---");
        DungeonFacade facade = new DungeonFacade();
        
        facade.setRandomSeed(1L);
        AdventureResult result = facade.runAdventure(hero, boss, ultimateAttack);

        System.out.println("\n--- Detailed Combat Log ---");
        for (String line : result.getLog()) {
            System.out.println(line);
        }
        System.out.println("\n--- Final Summary ---");
        System.out.println("Battle Outcome: " + result.getWinner() + " wins!");
        System.out.println("Total Rounds: " + result.getRounds());
        System.out.println("Final Reward: " + result.getReward());

        System.out.println("\n=== Demo Complete ===");
    }
}
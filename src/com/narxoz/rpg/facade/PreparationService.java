package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

public class PreparationService {
    public String prepare(HeroProfile hero, BossEnemy boss, AttackAction action) {
        if (hero == null || boss == null || action == null) {
            return "Failed to prepare: missing participants or action.";
        }
        return "Hero " + hero.getName() + " prepares to use " + action.getActionName() +  " against " + boss.getName() + ". (Initial potential: " + action.getDamage() + " damage)";
    }
}
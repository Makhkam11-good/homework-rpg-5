package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;

public class GameLogger {
    public static void logAttackDetails(String type, AttackAction action) {
        System.out.println("[" + type + "] " + action.getActionName() + " | Damage: " + action.getDamage() + " | Effects: " + action.getEffectSummary());
    }
}
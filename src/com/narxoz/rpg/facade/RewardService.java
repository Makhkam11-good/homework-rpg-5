package com.narxoz.rpg.facade;

public class RewardService {
    private final String[] possibleLoots = {
        "Ancient Coin", "Dragon Scale", "Magic Potion", "Mystic Rune", "Wooden Spoon"};
        
    public String determineReward(AdventureResult battleResult) {
        if (battleResult == null || battleResult.getWinner() == null) {
            return "No reward for an invalid battle.";
        }
        int lootIndex = BattleService.getInstance().getRandomInt(possibleLoots.length);
        String loot = possibleLoots[lootIndex];

        return "Victory Loot: " + loot + " + 100 Gold";
    }
}
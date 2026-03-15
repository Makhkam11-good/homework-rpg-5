# Project Progress Tracker

## Current Status: Step 1 [COMPLETED]

## Step Breakdown

### Step 1: Complete Hero and Enemy Basic Implementation [COMPLETED]
- [x] Implement `HeroProfile.takeDamage()`
- [x] Implement `HeroProfile.isAlive()`
- [x] Implement `BossEnemy.takeDamage()`
- [x] Implement `BossEnemy.isAlive()`

### Step 2: Implement BasicAttack [PENDING]
- [ ] Implement `BasicAttack.getActionName()`
- [ ] Implement `BasicAttack.getDamage()`
- [ ] Implement `BasicAttack.getEffectSummary()`

### Step 3: Implement FireRuneDecorator [PENDING]
- [ ] Implement `FireRuneDecorator.getActionName()`
- [ ] Implement `FireRuneDecorator.getDamage()` with fire bonus
- [ ] Implement `FireRuneDecorator.getEffectSummary()`

### Step 4: Implement PoisonCoatingDecorator [PENDING]
- [ ] Implement `PoisonCoatingDecorator.getActionName()`
- [ ] Implement `PoisonCoatingDecorator.getDamage()` with poison bonus
- [ ] Implement `PoisonCoatingDecorator.getEffectSummary()`

### Step 5: Implement CriticalFocusDecorator [PENDING]
- [ ] Implement `CriticalFocusDecorator.getActionName()`
- [ ] Implement `CriticalFocusDecorator.getDamage()` with critical bonus
- [ ] Implement `CriticalFocusDecorator.getEffectSummary()`

### Step 6: Implement PreparationService [PENDING]
- [ ] Validate hero, boss, and action inputs
- [ ] Return meaningful preparation summary

### Step 7: Implement BattleService Battle Logic [PENDING]
- [ ] Implement turn-based combat
- [ ] Track rounds and handle attacks
- [ ] Return AdventureResult with winner

### Step 8: Implement RewardService [PENDING]
- [ ] Determine reward based on battle outcome
- [ ] Return meaningfull reward description

### Step 9: Fix DungeonFacade Workflow [PENDING]
- [ ] Coordinate services in correct order (Prep → Battle → Reward)

### Step 10: Complete Main Demo [PENDING]
- [ ] Create meaningful hero and boss
- [ ] Create base and decorated attacks
- [ ] Run full dungeon scenario
- [ ] Display results clearly

## Files Modified/Created

### Step 1:
- `src/com/narxoz/rpg/hero/HeroProfile.java` - MODIFIED
- `src/com/narxoz/rpg/enemy/BossEnemy.java` - MODIFIED

### Step 2:
- `src/com/narxoz/rpg/decorator/BasicAttack.java` - MODIFIED

### Step 3:
- `src/com/narxoz/rpg/decorator/FireRuneDecorator.java` - MODIFIED

### Step 4:
- `src/com/narxoz/rpg/decorator/PoisonCoatingDecorator.java` - MODIFIED

### Step 5:
- `src/com/narxoz/rpg/decorator/CriticalFocusDecorator.java` - MODIFIED

### Step 6:
- `src/com/narxoz/rpg/facade/PreparationService.java` - MODIFIED

### Step 7:
- `src/com/narxoz/rpg/facade/BattleService.java` - MODIFIED

### Step 8:
- `src/com/narxoz/rpg/facade/RewardService.java` - MODIFIED

### Step 9:
- `src/com/narxoz/rpg/facade/DungeonFacade.java` - MODIFIED

### Step 10:
- `src/com/narxoz/rpg/Main.java` - MODIFIED

## Project Structure (Target)
```
homework-rpg-5/
├── src/
│   └── com/
│       └── narxoz/
│           └── rpg/
│               ├── Main.java (fully implemented demo)
│               ├── decorator/
│               │   ├── AttackAction.java (interface - DONE)
│               │   ├── ActionDecorator.java (abstract base - DONE)
│               │   ├── BasicAttack.java (concrete component)
│               │   ├── FireRuneDecorator.java (decorator)
│               │   ├── PoisonCoatingDecorator.java (decorator)
│               │   └── CriticalFocusDecorator.java (decorator)
│               ├── facade/
│               │   ├── AdventureResult.java (result object - DONE)
│               │   ├── DungeonFacade.java (facade)
│               │   ├── PreparationService.java (subsystem)
│               │   ├── BattleService.java (subsystem)
│               │   └── RewardService.java (subsystem)
│               ├── hero/
│               │   └── HeroProfile.java (hero entity)
│               ├── enemy/
│               │   └── BossEnemy.java (enemy entity)
│               └── hints/
│                   ├── DECORATOR_HINTS.md
│                   └── FACADE_HINTS.md
├── out/ (compiled classes)
├── ASSIGNMENT.md
├── README.md
├── QUICKSTART.md
├── FAQ.md
├── STUDENT_CHECKLIST.md
└── TASK.md (this file)
```

## Design Patterns / Architecture Used

### Decorator Pattern
- **Component**: `AttackAction` interface
- **Concrete Component**: `BasicAttack` (base attack)
- **Decorator**: `ActionDecorator` (abstract wrapper)
- **Concrete Decorators**:
  - `FireRuneDecorator`: +5 damage, adds fire effect
  - `PoisonCoatingDecorator`: +3 damage, adds poison effect
  - `CriticalFocusDecorator`: +4 damage, adds critical effect
- **Behavior**: Decorators compose damage and effect summaries of wrapped actions

### Facade Pattern
- **Facade**: `DungeonFacade` (single entry point)
- **Subsystems**:
  - `PreparationService`: validates adventure inputs
  - `BattleService`: implements turn-based combat logic
  - `RewardService`: determines post-battle rewards
- **Result Object**: `AdventureResult` packages winner, rounds, reward, and battle log
- **Workflow**: Preparation → Battle → Reward

### Game Rules
- **Combat**: Turn-based, hero attacks first each round, boss retaliates
- **Damage**: Hero uses decorated attack, boss uses fixed attack power with randomness
- **Victory**: First combatant to reach 0 HP loses
- **Reward**: Winner receives gold based on opponent's starting health
- **Rounds**: Maximum 100 rounds to prevent infinite loops

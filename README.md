# comp305-final-project

The goal of this project is to create a Pokémon simulator 
that allows users to catch and train Pokémon.

# Classes

## Pokémon
All Pokémon have the following variables:
- Species Name
- Stats (HP, Attack, Defense, SpAtk, SpDef, Speed)
- Level (Min: 1, Max: 100)
- Type 1  
- Type 2 -> Optional
- Move List (Max: 4 Moves.Moves)

Pokémon can perform the following actions:
- Train in order to level up
- Evolve from one species into another
- Learn new moves
- Use attacks on enemy Pokémon

## Trainer
Trainers have the following variables:
- Current Party (Min: 1, Max: 6)

Trainers can perform the following actions:
- Catch new Pokémon
- Change the current Party
- Give Pokémon Directions (Train, Attack)
- Open the PC (Collection of all Pokémon caught)
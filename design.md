# Your Design

---
- What classes do I need? Would it be helpful to have any interfaces or abstract classes and for what?
    - Abstract Classes
      - Blank PokemonClasses.Pokemon  - Trainers
    - Interfaces
      - Maybe Moves.Moves / Attacks (?)
    - Classes
      - Specific PokemonClasses.Pokemon    - Squirtle, Charmander, Bulbasaur, Pikachu, etc.
      - Specific Moves.Moves
      - User's Trainer
---

## For each Interface

## Move
- methods: No methods -> Dependent on PokemonClasses.Pokemons
- vars: String name, String type, Int powerValue

---

## For each Abstract class

## Blank PokemonClasses.Pokemones this class need to implement any interfaces or extend any classes? Any you wrote or others.
  - No, this is a stand-alone class.
- What is the information (instance variables) that this class has that will be similar across child classes?
- What are the types, should they have any default values?
  - Level -> int
  - HP -> int
  - Atk -> int
  - Def -> int
  - SpAtk -> int
  - SpDef -> int
  - Speed -> int
  - Type1/Type2 -> String
  - Moves.Moves -> ArrayList<Move>
  - EvolutionLevel -> int
  - fainted -> boolean
- What are the promised actions (methods) for this class?
  - Attack
  - Defend
  - Train
  - Evolve
- What are the parameters needed?
  - Attack -> Move, Another PokemonClasses.Pokemons
  - Defend -> HP: int
  - Train -> Opponents to fight: int
  - Evolve -> N/A
- What will they return?
  - Attack -> return int: the damage to deal
  - Defend -> return boolean: whether or not the PokemonClasses.Pokemonived
  - Train -> N/A
  - Evolve -> return PokemonClasses.Pokemon replacement PokemonClasses.Pokemonhich of these should be concrete and which abstract?
  - Attack -> concrete
  - Defend -> concrete
  - Train -> concrete
  - Evolve -> abstract

## Trainers
- Does this class need to implement any interfaces or extend any classes? Any you wrote or others.
  - No, this is a stand alone class
- What is the information (instance variables) that this class has that will be similar across child classes?
- What are the types, should they have any default values?
  - Name: String
  - pokemonInParty: ArrayList<PokemonClasses.Pokemon pokemonInPC: ArrayList<PokemonClasses.Pokemonhat are the promised actions (methods) for this class?
  - Battle
  - Catch
  - Train
  - SwapParty
- What are the parameters needed?
  - Battle -> Difficulty: int
  - Catch -> N/A
  - Train -> Opponents to fight: int, PokemonClasses.Pokemonprompt the user)
  - SwapParty -> N/A
- What will they return?
  - Battle -> victory: boolean
  - Catch -> success: boolean
  - Train -> N/A
  - SwapParty -> success: boolean
- Which of these should be concrete and which abstract?
  - Battle -> abstract
  - Catch -> abstract
  - Train -> abstract
  - SwapParty -> abstract
  - Note: Only the playable trainer is capable of these methods. NPC trainers cannot perform these actions, making them all abstract
---

## For each class

## Specific PokemonClasses.Pokemonirtle, Bulbasaur, Charmander, etc.)
- Does this class need to implement any interfaces or extend any classes? Any you wrote or others.
  - Blank PokemonClasses.Pokemonat is the information (instance variables) that this class has?
  - Stats tailored for each individual PokemonClasses.Pokemonat are the types?
  - Level -> int
  - HP -> int
  - Atk -> int
  - Def -> int
  - SpAtk -> int
  - SpDef -> int
  - Speed -> int
  - Type1/Type2 -> String
  - Moves.Moves -> ArrayList<Move>
  - EvolutionLevel -> int
  - fainted -> boolean
- What are the promised actions (methods) for this class?
    - Attack
    - Defend
    - Train
    - Evolve
- What are the parameters needed?
    - Attack -> Move, Another PokemonClasses.Pokemons
    - Defend -> HP: int
    - Train -> Opponents to fight: int
    - Evolve -> N/A
- What will they return?
    - Attack -> return int: the damage to deal
    - Defend -> return boolean: whether or not the PokemonClasses.Pokemonived
    - Train -> N/A
    - Evolve -> return PokemonClasses.Pokemon replacement PokemonClasses.Pokemonich of these should be concrete and which abstract?
    - Attack -> concrete
    - Defend -> concrete
    - Train -> concrete
    - Evolve -> abstract

## Specific Moves.Moves (Water Gun, Vine Whip, Fire Blast, etc.)
- Does this class need to implement any interfaces or extend any classes? Any you wrote or others.
  - Implement the Move Interface
- What is the information (instance variables) that this class has?
- What are the types?
  - Name -> String
  - Type -> String
  - PowerValue -> int
- What are the promised actions (methods) for this class?
  - None

## User Trainer
- Does this class need to implement any interfaces or extend any classes? Any you wrote or others.
  - Extend the Trainer Class
- What is the information (instance variables) that this class has?
- What are the types, should they have any default values?
    - Name: String
    - pokemonInParty: ArrayList<PokemonClasses.Pokemon - pokemonInPC: ArrayList<PokemonClasses.Pokemonhat are the promised actions (methods) for this class?
    - Battle
    - Catch
    - Train
    - SwapParty
- What are the parameters needed?
    - Battle -> Difficulty: int
    - Catch -> N/A
    - Train -> Opponents to fight: int, PokemonClasses.Pokemonprompt the user)
    - SwapParty -> N/A
- What will they return?
    - Battle -> victory: boolean
    - Catch -> success: boolean
    - Train -> N/A
    - SwapParty -> success: boolean
- Which of these should be concrete and which abstract?
    - Battle -> abstract
    - Catch -> abstract
    - Train -> abstract
    - SwapParty -> abstract

## NPC Trainer
- The NPC Trainer will extend the Trainer Class, however, it will simply just have a random collection
of PokemonClasses.Pokemonn ArrayList. NPC Trainers are not capable of Catching new PokemonClasses.Pokemonining current PokemonClasses.Pokemonswapping out their party. This class will be used for the Battle method called by the User Trainer.

---
## Testing for each method

## Blank PokemonClasses.Pokemontack -> Neutral Attacks, Super-Effective Attacks, Doubly Super-Effective Attacks, 
Not Very Effective Attacks, Quarterly Effective Attacks, Non-Effective Attacks 
- Defend -> PokemonSurvived, PokemonDidntSurvive
- Train -> Train on <= 0 PokemonClasses.Pokemonin on >= 1 PokemonClasses.Pokemonwe hit evolution threshold while training,
If we hit level 100 while training (max), If we hit a new move threshold while training

## Trainers
- All Abstract

## Specific PokemonClasses.Pokemonolve -> checkIfPokemonEvolvedCorrectly

## User Trainer
- Battle -> winBattle, loseBattle
- Catch -> catchAPokemonWhilePartyFull, catchAPokemonWhilePartyNotFull, failACatch, dontCatch
- Train -> Train on <= 0 PokemonClasses.Pokemonin on >= 1 PokemonClasses.Pokemonwe hit evolution threshold while training,
  If we hit level 100 while training (max), If we hit a new move threshold while training
- SwapParty -> successfullySwapPokemon, dropOffPokemon, pickupPokemonWithPartySpace, swapWithNonexistentPokemon,
dropOffPokemonWithOnePokemon




package PokemonClasses;

import Moves.*;

import java.util.ArrayList;

public class Pikachu extends Pokemon {
    public Pikachu(int level, ArrayList<Moves> attacks, ArrayList<Moves> learnedMoves) {
        super("Pikachu",level, 35, 55, 40, 50, 50, 90);
        this.attacks = attacks;
        this.learnedMoves = learnedMoves;
        this.EvolutionLevel = -1;
        this.type1 = "Electric";
        this.type2 = "";
        updateMoves();
    }

    // This separate constructor is used for NPC trainers
    public Pikachu(){
        super("Pikachu", 28, 35, 55, 40, 50, 50, 90);
        this.attacks.add(new IronTail());
        this.attacks.add(new Spark());
        this.attacks.add(new QuickAttack());
        this.attacks.add(new ThunderShock());
        this.type1 = "Electric";
        this.type2 = "";
    }

    public void updateMoves(){
        if (level >= 1 && !hasLearnedMove("Nuzzle")) {
            attacks.add(new Nuzzle());
            learnedMoves.add(new Nuzzle());
            System.out.println("Pikachu has learned Nuzzle!");
        }
        if (level >= 1 && !hasLearnedMove("QuickAttack")) {
            attacks.add(new QuickAttack());
            learnedMoves.add(new QuickAttack());
            System.out.println("Pikachu has learned Quick Attack!");
        }
        if (level >= 1 && !hasLearnedMove("ThunderShock")) {
            attacks.add(new ThunderShock());
            learnedMoves.add(new ThunderShock());
            System.out.println("Pikachu has learned Thunder Shock!");
        }
        if(level >= 1 && !hasLearnedMove("Feint")){
            attacks.add(new Feint());
            learnedMoves.add(new Feint());
            System.out.println("Pikachu has learned Feint!");
        }
        if(level >= 20 && !hasLearnedMove("Spark")){
            swapMoves(new Spark(),"Spark");
        }
        if(level >= 28 && !hasLearnedMove("IronTail")){
            swapMoves(new IronTail(),"Iron Tail");
        }
        if(level >= 32 && !hasLearnedMove("Discharge")){
            swapMoves(new Discharge(),"Discharge");
        }
        if(level >= 36 && !hasLearnedMove("Thunderbolt")){
            swapMoves(new Thunderbolt(),"Thunderbolt");
        }
        if(level >= 44 && !hasLearnedMove("Thunder")){
            swapMoves(new Thunder(),"Thunder");
        }
    }



    public Pokemon evolve(){
        return this;
    }
}

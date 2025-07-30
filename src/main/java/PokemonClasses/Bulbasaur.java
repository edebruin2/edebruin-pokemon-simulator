package PokemonClasses;

import Moves.*;

import java.util.ArrayList;

public class Bulbasaur extends Pokemon {


    public Bulbasaur(int level, ArrayList<Moves> attacks, ArrayList<Moves> learnedMoves){
        super("Bulbasaur", level, 45, 49, 49, 65, 65, 45);
        this.attacks = attacks;
        this.learnedMoves = learnedMoves;
        this.EvolutionLevel = 16;
        this.type1 = "Grass";
        this.type2 = "Poison";
        updateMoves();
    }

    public void updateMoves(){
        if (level >= 1 && !hasLearnedMove("Tackle")) {
            attacks.add(new Tackle());
            learnedMoves.add(new Tackle());
            System.out.println("Bulbasaur has learned Tackle!");
        }
        if(level >= 3 && !hasLearnedMove("VineWhip")){
            attacks.add(new VineWhip());
            learnedMoves.add(new VineWhip());
            System.out.println("Bulbasaur has learned Vine Whip!");
        }
        if(level >= 12 && !hasLearnedMove("RazorLeaf")){
            attacks.add(new RazorLeaf());
            learnedMoves.add(new RazorLeaf());
            System.out.println("Bulbasaur has learned Razor Leaf!");
        }
    }

    public Pokemon evolve(){
        if(this.level >= EvolutionLevel){
            return new Ivysaur(this.level, new ArrayList<>(this.attacks), new ArrayList<>(this.learnedMoves));
        }
        return this;
    }
}

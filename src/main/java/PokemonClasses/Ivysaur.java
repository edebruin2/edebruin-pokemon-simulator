package PokemonClasses;

import Moves.*;

import java.util.ArrayList;

public class Ivysaur extends Pokemon {

    public Ivysaur(int level, ArrayList<Moves> attacks, ArrayList<Moves> learnedMoves) {
        super("Ivysaur", level, 60, 62, 63, 80, 80, 60);
        this.attacks = attacks;
        this.learnedMoves = learnedMoves;
        this.EvolutionLevel = 32;
        this.type1 = "Grass";
        this.type2 = "Poison";
        updateMoves();
    }

    public Ivysaur(){
        super("Ivysaur", 25, 60, 62, 63, 80, 80, 60);
        this.attacks.add(new SeedBomb());
        this.attacks.add(new Tackle());
        this.attacks.add(new RazorLeaf());
        this.attacks.add(new VineWhip());
        this.type1 = "Grass";
        this.type2 = "Poison";
    }

    public void updateMoves(){
        if (level >= 1 && !hasLearnedMove("Tackle")) {
            attacks.add(new Tackle());
            learnedMoves.add(new Tackle());
            System.out.println("Ivysaur has learned Tackle!");
        }
        if(level >= 1 && !hasLearnedMove("VineWhip")){
            attacks.add(new VineWhip());
            learnedMoves.add(new VineWhip());
            System.out.println("Ivysaur has learned Vine Whip!");
        }
        if(level >= 12 && !hasLearnedMove("RazorLeaf")){
            attacks.add(new RazorLeaf());
            learnedMoves.add(new RazorLeaf());
            System.out.println("Ivysaur has learned Razor Leaf!");
        }
        if(level >= 20 && !hasLearnedMove("SeedBomb")){
            attacks.add(new SeedBomb());
            learnedMoves.add(new SeedBomb());
            System.out.println("Ivysaur has learned Seed Bomb!");
        }
        if(level >= 25 && !hasLearnedMove("TakeDown")){
            swapMoves(new TakeDown(), "Take Down");
        }

    }


    public Pokemon evolve(){
        if(this.level >= EvolutionLevel){
            return new Venusaur(this.level, new ArrayList<>(this.attacks), new ArrayList<>(this.learnedMoves));
        }
        return this;
    }
}

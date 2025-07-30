package PokemonClasses;

import Moves.*;

import java.util.ArrayList;

public class Venusaur extends Pokemon {
    public Venusaur(int level, ArrayList<Moves> attacks, ArrayList<Moves> learnedMoves) {
        super("Venusaur",level, 80, 82, 83, 100, 100, 80);
        this.attacks = attacks;
        this.learnedMoves = learnedMoves;
        this.EvolutionLevel = -1;
        this.type1 = "Grass";
        this.type2 = "Poison";
        updateMoves();
    }

    public void updateMoves(){
        if (level >= 1 && !hasLearnedMove("Tackle")) {
            attacks.add(new Tackle());
            learnedMoves.add(new Tackle());
            System.out.println("Venusaur has learned Tackle!");
        }
        if (level >= 1 && !hasLearnedMove("PetalDance")) {
            if (attacks.size() < 4) {
                attacks.add(new PetalDance());
                learnedMoves.add(new PetalDance());
                System.out.println("Venusaur has learned Petal Dance!");
            }
            else{
                swapMoves(new PetalDance(),"Petal Dance");
            }
        }
        if(level >= 1 && !hasLearnedMove("VineWhip")){
            attacks.add(new VineWhip());
            learnedMoves.add(new VineWhip());
            System.out.println("Venusaur has learned Vine Whip!");
        }
        if(level >= 12 && !hasLearnedMove("RazorLeaf")){
            attacks.add(new RazorLeaf());
            learnedMoves.add(new RazorLeaf());
            System.out.println("Venusaur has learned Razor Leaf!");
        }
        if(level >= 20 && !hasLearnedMove("SeedBomb")){
            swapMoves(new SeedBomb(),"Seed Bomb");
        }
        if(level >= 25 && !hasLearnedMove("TakeDown")){
            swapMoves(new TakeDown(), "Take Down");
        }
        if(level >= 51 && !hasLearnedMove("PowerWhip")){
            swapMoves(new PowerWhip(), "Power Whip");
        }
        if(level >= 58 && !hasLearnedMove("SolarBeam")){
            swapMoves(new SolarBeam(), "Solar Beam");
        }
    }

    public Pokemon evolve(){
        return this;
    }
}

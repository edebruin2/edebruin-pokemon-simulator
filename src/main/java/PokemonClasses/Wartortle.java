package PokemonClasses;

import Moves.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Wartortle extends Pokemon {

    public Wartortle(int level, ArrayList<Moves> attacks, ArrayList<Moves> learnedMoves) {
        super("Wartortle", level, 59, 63, 80, 65, 80, 58);
        this.attacks = attacks;
        this.learnedMoves = learnedMoves;
        this.EvolutionLevel = 36;
        this.type1 = "Water";
        this.type2 = "";
        updateMoves();
    }

    public void updateMoves(){
        if (level >= 1 && !hasLearnedMove("Tackle")) {
            attacks.add(new Tackle());
            learnedMoves.add(new Tackle());
            System.out.println("Wartortle has learned Tackle!");
        }
        if(level >= 3 && !hasLearnedMove("WaterGun")){
            attacks.add(new WaterGun());
            learnedMoves.add(new WaterGun());
            System.out.println("Wartortle has learned Water Gun!");
        }
        if(level >= 9 && !hasLearnedMove("RapidSpin")){
            attacks.add(new RapidSpin());
            learnedMoves.add(new RapidSpin());
            System.out.println("Wartortle has learned Rapid Spin!");
        }
        if(level >= 12 && !hasLearnedMove("Bite")){
            attacks.add(new Bite());
            learnedMoves.add(new Bite());
            System.out.println("Wartortle has learned Bite!");
        }
        if(level >= 15 && !hasLearnedMove("WaterPulse") ) {
            swapMoves(new WaterPulse(), "Water Pulse");
        }
        if (level >= 30 && !hasLearnedMove("AquaTail")) {
            swapMoves(new AquaTail(),"Aqua Tail");
        }
    }


    public Pokemon evolve(){
        if(this.level >= EvolutionLevel){
            return new Blastoise(this.level, new ArrayList<>(this.attacks), new ArrayList<>(this.learnedMoves));
        }
        return this;
    }
}

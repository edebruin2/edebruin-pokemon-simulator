package PokemonClasses;

import Moves.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Blastoise extends Pokemon {
    public Blastoise(int level, ArrayList<Moves> attacks, ArrayList<Moves> learnedMoves) {
        super("Blastoise", level, 79, 83, 100, 85, 105, 78);
        this.attacks = attacks;
        this.learnedMoves = learnedMoves;
        this.EvolutionLevel = -1;
        this.type1 = "Water";
        this.type2 = "";
        updateMoves();
    }

    public void updateMoves(){
        if (level >= 1 && !hasLearnedMove("Tackle")) {
            attacks.add(new Tackle());
            learnedMoves.add(new Tackle());
            System.out.println("Blastoise has learned Tackle!");
        }
        if(level >= 3 && !hasLearnedMove("WaterGun")){
            attacks.add(new WaterGun());
            learnedMoves.add(new WaterGun());
            System.out.println("Blastoise has learned Water Gun!");
        }
        if(level >= 9 && !hasLearnedMove("RapidSpin")){
            attacks.add(new RapidSpin());
            learnedMoves.add(new RapidSpin());
            System.out.println("Blastoise has learned Rapid Spin!");
        }
        if(level >= 12 && !hasLearnedMove("Bite")){
            attacks.add(new Bite());
            learnedMoves.add(new Bite());
            System.out.println("Blastoise has learned Bite!");
        }
        if(level >= 15 && !hasLearnedMove("WaterPulse") ) {
            swapMoves(new WaterPulse(), "Water Pulse");
        }
        if (level >= 30 && !hasLearnedMove("AquaTail")) {
            swapMoves(new AquaTail(),"Aqua Tail");
        }
        if (level >= 49 && !hasLearnedMove("HydroPump")) {
            swapMoves(new HydroPump(),"Hydro Pump");
        }
        if (level >= 30 && !hasLearnedMove("WaveCrash")) {
            swapMoves(new WaveCrash(),"Wave Crash");
        }
    }


    public Pokemon evolve(){
        return this;
    }
}

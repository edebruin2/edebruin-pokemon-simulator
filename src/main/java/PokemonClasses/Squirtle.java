package PokemonClasses;
import Moves.*;


import java.util.ArrayList;

public class Squirtle extends Pokemon {

    public Squirtle(int level, ArrayList<Moves> attacks, ArrayList<Moves> learnedMoves) {
        super("Squirtle", level, 44, 48, 65, 50, 64, 43);
        this.attacks = attacks;
        this.learnedMoves = learnedMoves;
        this.EvolutionLevel = 16;
        this.type1 = "Water";
        this.type2 = "";
        updateMoves();
    }

    public Squirtle(){
        super("Squirtle", 12, 44, 48, 65, 50, 64, 43);
        this.attacks.add(new Tackle());
        this.attacks.add(new WaterGun());
        this.attacks.add(new RapidSpin());
        this.attacks.add(new Bite());
        this.type1 = "Water";
        this.type2 = "";
    }

    public void updateMoves(){
        if (level >= 1 && !hasLearnedMove("Tackle")) {
            attacks.add(new Tackle());
            learnedMoves.add(new Tackle());
            System.out.println("Squirtle has learned Tackle!");
        }
        if(level >= 3 && !hasLearnedMove("WaterGun")){
            attacks.add(new WaterGun());
            learnedMoves.add(new WaterGun());
            System.out.println("Squirtle has learned Water Gun!");
        }
        if(level >= 9 && !hasLearnedMove("RapidSpin")){
            attacks.add(new RapidSpin());
            learnedMoves.add(new RapidSpin());
            System.out.println("Squirtle has learned Rapid Spin!");
        }
        if(level >= 12 && !hasLearnedMove("Bite")){
            attacks.add(new Bite());
            learnedMoves.add(new Bite());
            System.out.println("Squirtle has learned Bite!");
        }
        if(level >= 15 && !hasLearnedMove("WaterPulse") ){
            swapMoves(new WaterPulse(), "Water Pulse");
        }
    }



    public Pokemon evolve(){
        if(this.level >= EvolutionLevel){
            return new Wartortle(this.level, new ArrayList<>(this.attacks), new ArrayList<>(this.learnedMoves));
        }
            return this;
    }
}

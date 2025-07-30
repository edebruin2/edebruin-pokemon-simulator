package PokemonClasses;

import Moves.*;

import java.util.ArrayList;

public class Charizard extends Pokemon {

    public Charizard(int level, ArrayList<Moves> attacks, ArrayList<Moves> learnedMoves) {
        super("Charizard", level, 78, 84, 78, 109, 85, 100);
        this.attacks = attacks;
        this.learnedMoves = learnedMoves;
        this.EvolutionLevel = -1;
        this.type1 = "Fire";
        this.type2 = "Flying";
        updateMoves();
    }

    public Charizard(){
        super("Charizard", 40, 78, 84, 78, 109, 85, 100);
        this.attacks.add(new DragonClaw());
        this.attacks.add(new Flamethrower());
        this.attacks.add(new Slash());
        this.attacks.add(new DragonBreath());
        this.type1 = "Fire";
        this.type2 = "Flying";
    }

    public void updateMoves(){
        if (level >= 1 && !hasLearnedMove("Scratch")) {
            attacks.add(new Scratch());
            learnedMoves.add(new Scratch());
            System.out.println("Charizard has learned Scratch!");
        }
        if (level >= 1 && !hasLearnedMove("DragonClaw")) {
            attacks.add(new DragonClaw());
            learnedMoves.add(new DragonClaw());
            System.out.println("Charizard has learned Dragon Claw!");
        }
        if(level >= 1 && !hasLearnedMove("Ember")){
            attacks.add(new Ember());
            learnedMoves.add(new Ember());
            System.out.println("Charizard has learned Ember!");
        }
        if(level >= 1 && !hasLearnedMove("HeatWave")){
            attacks.add(new HeatWave());
            learnedMoves.add(new HeatWave());
            System.out.println("Charizard has learned Heat Wave!");
        }
        if(level >= 12 && !hasLearnedMove("DragonBreath")){
            swapMoves(new DragonBreath(), "Dragon Breath");
        }
        if(level >= 19 && !hasLearnedMove("FireFang")){
            swapMoves(new FireFang(), "Fire Fang");
        }
        if(level >= 24 && !hasLearnedMove("Slash")){
            swapMoves(new Slash(), "Slash");
        }
        if(level >= 30 && !hasLearnedMove("Flamethrower")){
            swapMoves(new Flamethrower(), "Flamethrower");
        }
        if(level >= 46 && !hasLearnedMove("FireSpin")){
            swapMoves(new FireSpin(), "Fire Spin");
        }
        if(level >= 54 && !hasLearnedMove("Inferno")){
            swapMoves(new Inferno(), "Inferno");
        }
        if(level >= 62 && !hasLearnedMove("FlareBlitz")){
            swapMoves(new FlareBlitz(), "Flare Blitz");
        }
    }

    public Pokemon evolve(){
        return this;
    }

}

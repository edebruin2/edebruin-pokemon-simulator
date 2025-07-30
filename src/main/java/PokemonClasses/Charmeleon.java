package PokemonClasses;

import Moves.*;

import java.util.ArrayList;

public class Charmeleon extends Pokemon {

    public Charmeleon(int level, ArrayList<Moves> attacks, ArrayList<Moves> learnedMoves) {
        super("Charmeleon", level, 58, 64, 58, 80, 65, 80);
        this.attacks = attacks;
        this.learnedMoves = learnedMoves;
        this.EvolutionLevel = 36;
        this.type1 = "Fire";
        this.type2 = "";
        updateMoves();
    }

    public void updateMoves(){
        if (level >= 1 && !hasLearnedMove("Scratch")) {
            attacks.add(new Scratch());
            learnedMoves.add(new Scratch());
            System.out.println("Charmeleon has learned Scratch!");
        }
        if(level >= 1 && !hasLearnedMove("Ember")){
            attacks.add(new Ember());
            learnedMoves.add(new Ember());
            System.out.println("Charmeleon has learned Ember!");
        }
        if(level >= 12 && !hasLearnedMove("DragonBreath")){
            attacks.add(new DragonBreath());
            learnedMoves.add(new DragonBreath());
            System.out.println("Charmeleon has learned Dragon Breath!");
        }
        if(level >= 19 && !hasLearnedMove("FireFang")){
            attacks.add(new FireFang());
            learnedMoves.add(new FireFang());
            System.out.println("Charmeleon has learned Fire Fang!");
        }
        if(level >= 24 && !hasLearnedMove("Slash")){
            swapMoves(new Slash(), "Slash");
        }
        if(level >= 30 && !hasLearnedMove("Flamethrower")){
            swapMoves(new Flamethrower(), "Flamethrower");
        }
    }

    public Pokemon evolve(){
        if(this.level >= EvolutionLevel){
            return new Charizard(this.level, new ArrayList<>(this.attacks), new ArrayList<>(this.learnedMoves));
        }
        return this;
    }


}

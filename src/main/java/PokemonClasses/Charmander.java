package PokemonClasses;

import Moves.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Charmander extends Pokemon {

    public Charmander(int level, ArrayList<Moves> attacks, ArrayList<Moves> learnedMoves) {
        super ("Charmander",level, 39, 52, 43, 60, 50, 65);
        this.attacks = attacks;
        this.learnedMoves = learnedMoves;
        this.EvolutionLevel = 16;
        this.type1 = "Fire";
        this.type2 = "";
        updateMoves();
    }

    public void updateMoves(){
        if (level >= 1 && !hasLearnedMove("Scratch")) {
            attacks.add(new Scratch());
            learnedMoves.add(new Scratch());
            System.out.println("Charmander has learned Scratch!");
        }
        if(level >= 4 && !hasLearnedMove("Ember")){
            attacks.add(new Ember());
            learnedMoves.add(new Ember());
            System.out.println("Charmander has learned Ember!");
        }
        if(level >= 12 && !hasLearnedMove("DragonBreath")){
            attacks.add(new DragonBreath());
            learnedMoves.add(new DragonBreath());
            System.out.println("Charmander has learned Dragon Breath!");
        }
    }


    public Pokemon evolve(){
        if(this.level >= EvolutionLevel){
            return new Charmeleon(this.level, new ArrayList<>(this.attacks), new ArrayList<>(this.learnedMoves));
        }
        return this;
    }


}

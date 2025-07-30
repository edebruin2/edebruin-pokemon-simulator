import PokemonClasses.*;
import Moves.*;

public class NPC_Trainer extends Trainer{

    public NPC_Trainer() {
        this.pokemonInParty.add(new Pikachu());
        this.pokemonInParty.add(new Squirtle());
        this.pokemonInParty.add(new Ivysaur());
        this.pokemonInParty.add(new Charizard());
    }

    public boolean battle(){
        return true;
    }
    public boolean catchPokemon(){
        return true;
    }
    public void train (int opponents){}

    public Moves pickOptimalMove(Pokemon enemyPokemon, Pokemon attackingPokemon) {
        Moves bestMove = attackingPokemon.getAttacks().get(0);
        int maxDamage = -1;
        for (int i = 0; i<attackingPokemon.getAttacks().size(); i++){
            Moves testMove = attackingPokemon.getAttacks().get(i);
            if (testMove.getAttackType().equals("Attack")){
                int testDamage = attackingPokemon.calculateDamage(testMove.getPowerValue(),
                                                                attackingPokemon.getAttack(),
                                                                enemyPokemon.getDefense(),
                                                                attackingPokemon.calculateMultiplier(testMove, enemyPokemon));
                if(testDamage >= maxDamage){
                    bestMove = testMove;
                }
            }
            else{
                int testDamage = attackingPokemon.calculateDamage(testMove.getPowerValue(),
                                                                attackingPokemon.getSpAtk(),
                                                                enemyPokemon.getSpDef(),
                                                                attackingPokemon.calculateMultiplier(testMove, enemyPokemon));
                if(testDamage >= maxDamage){
                    bestMove = testMove;
                }
            }
        }
        return bestMove;
    }

    public boolean SwapParty (){
        return true;
    }
}

import Moves.*;
import PokemonClasses.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


// The test cases for attack, defend, and train are universal across all Pokémon types.
// The evolution test applies to Pokémon based on the status of their evolution
class PokemonTest {

    @Test
    void attackNeutralEffectivePhysical() {
        Squirtle squirtle = new Squirtle(5, new ArrayList<>(), new ArrayList<>());
        Charmander charmander = new Charmander(5, new ArrayList<>(), new ArrayList<>());
        int damage = squirtle.attack(new Pound(), charmander);
        assertTrue(damage > 0);
    }
    @Test
    void attackNeutralEffectiveSpecial() {
        Squirtle squirtle = new Squirtle(5, new ArrayList<>(), new ArrayList<>());
        Charmander charmander = new Charmander(5, new ArrayList<>(), new ArrayList<>());
        int damage = squirtle.attack(new Pound(), charmander);
        assertTrue(damage > 0);
    }

    @Test
    void attackSuperEffective() {
        Squirtle squirtle = new Squirtle(5, new ArrayList<>(), new ArrayList<>());
        Charmander charmander = new Charmander(5, new ArrayList<>(), new ArrayList<>());
        int damage = squirtle.attack(new WaterGun(), charmander);
        assertTrue(damage > squirtle.attack(new Tackle(), charmander));
    }

    @Test
    void attackDoubleSuperEffective() {
        Bulbasaur bulbasaur = new Bulbasaur(5, new ArrayList<>(), new ArrayList<>());
        Squirtle squirtle = new Squirtle(5, new ArrayList<>(), new ArrayList<>());
        int damage = bulbasaur.attack(new VineWhip(), squirtle);
        assertTrue(damage > squirtle.getHP() / 2);
    }

    @Test
    void attackHalfEffective() {
        Squirtle squirtle = new Squirtle(5, new ArrayList<>(), new ArrayList<>());
        Bulbasaur bulbasaur = new Bulbasaur(5, new ArrayList<>(), new ArrayList<>());
        int damage = squirtle.attack(new Tackle(), bulbasaur);
        assertTrue(damage < bulbasaur.getHP() / 2);
    }

    @Test
    void attackQuarterEffective() {
        Squirtle squirtle = new Squirtle(5, new ArrayList<>(), new ArrayList<>());
        Bulbasaur bulbasaur = new Bulbasaur(5, new ArrayList<>(), new ArrayList<>());
        int damage = squirtle.attack(new WaterGun(), bulbasaur);
        assertTrue(damage < bulbasaur.getHP() / 4);
    }

    @Test
    void attackNotEffective() {
        Pikachu pikachu = new Pikachu(5, new ArrayList<>(), new ArrayList<>());
        Charmander charmander = new Charmander(5, new ArrayList<>(), new ArrayList<>());
        // Assuming ThunderShock is an Electric type move
        int damage = pikachu.attack(new ThunderShock(), charmander);
        assertEquals(0, damage);
    }

    @Test
    void attackingInvalidPokemon() {
        Squirtle squirtle = new Squirtle(5, new ArrayList<>(), new ArrayList<>());
        Pokemon invalidPokemon = null;
        assertThrows(NullPointerException.class, () -> squirtle.attack(new Tackle(), null));
    }

    @Test
    void defendSurvive() {
        Squirtle squirtle = new Squirtle(5, new ArrayList<>(), new ArrayList<>());
        int startingHP = squirtle.getHP();
        int damage = 10;
        int remainingHP = squirtle.defend(startingHP, damage);
        assertEquals(startingHP - damage, remainingHP);
    }

    @Test
    void defendNotSurvive() {
        Squirtle squirtle = new Squirtle(5, new ArrayList<>(), new ArrayList<>());
        int startingHP = squirtle.getHP();
        int damage = startingHP + 10;
        int remainingHP = squirtle.defend(startingHP, damage);
        assertTrue(remainingHP <= 0);
    }

    @Test
    void trainSingleRound() {
        Squirtle squirtle = new Squirtle(5, new ArrayList<>(), new ArrayList<>());
        squirtle.train(1);
        assertEquals(6, squirtle.getLevel());
    }

    @Test
    void trainMultiRound() {
        Squirtle squirtle = new Squirtle(5, new ArrayList<>(), new ArrayList<>());
        squirtle.train(9);
        assertEquals(14, squirtle.getLevel());
    }

    @Test
    void evolveValid() {
    }

    @Test
    void evolveAsHighestEvolution() {
    }

    @Test
    void doesNotLearnMove(){
    }

    @Test
    void learnsMoves(){
    }
}
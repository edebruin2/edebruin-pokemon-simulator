import PokemonClasses.Pikachu;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {

    @Test
    void winBattle() {
    }

    @Test
    void loseBattle() {
    }

    @Test
    void catchPokemonPartyFull() {
        User_Trainer user = new User_Trainer("Test Trainer");
        user.pokemonInParty.add(new Pikachu(5, new ArrayList<>(), new ArrayList<>()));
        user.pokemonInParty.add(new Pikachu(5, new ArrayList<>(), new ArrayList<>()));
        user.pokemonInParty.add(new Pikachu(5, new ArrayList<>(), new ArrayList<>()));
        user.pokemonInParty.add(new Pikachu(5, new ArrayList<>(), new ArrayList<>()));
        user.pokemonInParty.add(new Pikachu(5, new ArrayList<>(), new ArrayList<>()));
        user.pokemonInParty.add(new Pikachu(5, new ArrayList<>(), new ArrayList<>()));

        assertEquals(6, user.pokemonInParty.size());


    }
    @Test
    void catchPokemonPartyNotFull() {
    }
    @Test
    void catchPokemonFailedCatch() {
    }
    @Test
    void catchPokemonRefuseCatch() {
    }
    @Test
    void trainOnNoPokemon() {
    }
    @Test
    void trainOnOnePokemon() {
    }
    @Test
    void trainOnMultiplePokemon() {
    }
    @Test
    void trainAndEvolve() {
    }
    @Test
    void trainAndLearnNewMove() {
    }
    @Test
    void trainHitLevel100() {
    }
    @Test
    void swapPartyValid() {
    }
    @Test
    void swapPartyDropOff() {
    }
    @Test
    void swapPartyPickupWithFreeSpace() {
    }
    @Test
    void swapPartyWithNonexistentPokemon() {
    }
    @Test
    void dropOffPokemonWithOneInParty() {
    }
}
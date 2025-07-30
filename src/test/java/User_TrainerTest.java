import PokemonClasses.Bulbasaur;
import PokemonClasses.Pikachu;
import PokemonClasses.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class User_TrainerTest {

    @Mock
    private Scanner mockScanner;
    private ArrayList<Pokemon> pokemonInParty;
    private ArrayList<Pokemon> pokemonInPC;
    private User_Trainer trainer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
        pokemonInParty = new ArrayList<>();
        pokemonInPC = new ArrayList<>();
        trainer = new User_Trainer("Ash");
        trainer.pokemonInParty = pokemonInParty;
        trainer.pokemonInPC = pokemonInPC;
    }

    @Test
    void testSwapParty() {
        // Prepare the Pokémon
        Pokemon pikachu = new Pikachu (5, new ArrayList<>(), new ArrayList<>());
        Pokemon bulbasaur = new Bulbasaur (5, new ArrayList<>(), new ArrayList<>());
        pokemonInParty.add(pikachu);
        pokemonInPC.add(bulbasaur);

        // Simulate user input for swapping
        when(mockScanner.nextInt()).thenReturn(3, 1, 1); // Choose to swap, then pick 1st Pokémon from each list
        when(mockScanner.next()).thenReturn("yes", "no"); // Continue once then stop

        trainer.SwapParty();

        // Verify outcomes
        assertTrue(pokemonInParty.contains(bulbasaur));
        assertTrue(pokemonInPC.contains(pikachu));
    }

    @Test
    void testDropOffPokemon() {
        // Setup the Pokémon in the party
        Pokemon pikachu = new Pikachu(5, new ArrayList<>(), new ArrayList<>());
        pokemonInParty.add(pikachu);

        // Simulate user input for dropping off the first Pokémon
        when(mockScanner.nextInt()).thenReturn(1);  // Choose to drop off
        when(mockScanner.next()).thenReturn("no"); // End swapping after the operation

        trainer.SwapParty();

        // Assertions to ensure the Pokémon was moved from party to PC
        assertTrue(pokemonInPC.contains(pikachu), "Pikachu should be in PC");
        assertTrue(pokemonInParty.isEmpty(), "Party should be empty");
    }

    @Test
    void testPickUpPokemon() {
        // Setup the Pokémon in the PC
        Pokemon bulbasaur = new Bulbasaur(5, new ArrayList<>(), new ArrayList<>());
        pokemonInPC.add(bulbasaur);

        // Assume the party is not full for simplicity
        when(mockScanner.nextInt()).thenReturn(2, 1); // Choose to pick up, then select the first Pokémon in the PC
        when(mockScanner.next()).thenReturn("no"); // End swapping after the operation

        trainer.SwapParty();

        // Assertions to check the state of the lists after picking up the Pokémon
        assertTrue(pokemonInParty.contains(bulbasaur), "Bulbasaur should be in the party");
        assertTrue(pokemonInPC.isEmpty(), "PC should be empty");
    }

}

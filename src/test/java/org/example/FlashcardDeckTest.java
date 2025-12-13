package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class FlashcardDeckTest {

    @Test
    void testGetNextCard() {
        FlashcardDeck fcDeck = new FlashcardDeck();

        // Create new flashcards
        Flashcard fc1 = new Flashcard("Hi in Swedish?", "Hej");
        Flashcard fc2 = new Flashcard("Thanks in Swedish?", "Tack");

        // Add cards to the Deck
        fcDeck.addFlashcard(fc1);
        fcDeck.addFlashcard(fc2);

        assertEquals(fc1, fcDeck.getNextFlashcard()); // current Idx start at -1, get fc1 at idx0
        assertEquals(fc2, fcDeck.getNextFlashcard()); // get fc2 at idx1
    }

    @Test
    void testShuffleDoesntLoseCards() {
        FlashcardDeck fcDeck = new FlashcardDeck();

        // Create new flashcards
        Flashcard fc1 = new Flashcard("Hi in Swedish?", "Hej");
        Flashcard fc2 = new Flashcard("Thanks in Swedish?", "Tack");
        Flashcard fc3 = new Flashcard("What will you do in Swedish?", "Vad ska du göra idag?");

        // Add cards to the Deck
        fcDeck.addFlashcard(fc1);
        fcDeck.addFlashcard(fc2);
        fcDeck.addFlashcard(fc3);

        List<Flashcard> originalDeck = new ArrayList<>(fcDeck.getFlashcards());
        fcDeck.shuffleCards(); //shuffle original deck, fcDeck becomes shuffeldDeck

        //Check if originalDeck have different order as shuffeldDeck
        assertFalse(originalDeck.equals(fcDeck.getFlashcards()));
    }
}

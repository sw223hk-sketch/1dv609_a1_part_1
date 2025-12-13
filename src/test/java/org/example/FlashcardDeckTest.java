package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

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

        // Add cards to the Deck
        fcDeck.addFlashcard(fc1);
        fcDeck.addFlashcard(fc2);

        FlashcardDeck shuffledCards = Collections.shuffle(fcDeck);

        assertEquals(2, shuffledCards.getSize());
    }
}

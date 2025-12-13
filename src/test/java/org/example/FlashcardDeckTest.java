package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class FlashcardDeckTest {

    /* Next card should be corrcectly withdrawn.
     */
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

    /* Order of the cards in the deck should change after shuffling.
     */
    @Test
    void testShuffleReturnDifferentOrderCards() {
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

    @Test
    void testShuffleReturnEqualNumberCards() {
        FlashcardDeck toBeShuffledDeck = new FlashcardDeck();

        // Create new flashcards
        Flashcard fc1 = new Flashcard("Hi in Swedish?", "Hej");
        Flashcard fc2 = new Flashcard("Thanks in Swedish?", "Tack");
        Flashcard fc3 = new Flashcard("What will you do in Swedish?", "Vad ska du göra idag?");

        // Add cards to the Deck
        toBeShuffledDeck.addFlashcard(fc1);
        toBeShuffledDeck.addFlashcard(fc2);
        toBeShuffledDeck.addFlashcard(fc3);

        List<Flashcard> originalOrder = new ArrayList<>(toBeShuffledDeck.getFlashcards()); // orginal cards
        toBeShuffledDeck.shuffleCards(); // fcDeck become shuffled

        //Compare that size of deck before and after shuffle are the same
        assertEquals(originalOrder.size(), toBeShuffledDeck.getFlashcards().size()); // toBeShuffledDeck is FlashcardDeck type, cannot get size directly

    }

}

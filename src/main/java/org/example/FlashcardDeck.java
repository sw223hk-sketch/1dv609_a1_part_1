package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* FlashcardDeck has a deck of Flashcards.
 */
public class FlashcardDeck {

    // Attributes
    private List<Flashcard> flashcardDeck = new ArrayList<>();
    private int currentIdx = -1; // idx before the fisrt card

    // Constructor: start empty
    public FlashcardDeck() {
    }

    public void addFlashcard(Flashcard flashcard) {
        flashcardDeck.add(flashcard);
    }

    // Get next falshcard in the falshcardDeck arraylist
    public Flashcard getNextFlashcard() {
        // Empty deck
        if (flashcardDeck.isEmpty()) {
            return null;
        }
        // Non-empty deck
        if (currentIdx <= flashcardDeck.size() - 1) {
            currentIdx++;
        }
        return flashcardDeck.get(currentIdx);
    }

    // Get all flashcards from the Deck as list items
    public List<Flashcard> getFlashcards() {
        return flashcardDeck;

    }

    // Shuffle cards
    public void shuffleCards() {

        Collections.shuffle(flashcardDeck);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Flashcard fc : flashcardDeck) {
            sb.append(fc.toString()).append("\n");
        }
        return sb.toString();

    }
}

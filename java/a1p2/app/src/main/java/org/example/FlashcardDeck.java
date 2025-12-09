package org.example;

import java.util.ArrayList;

/* FlashcardDeck has a deck of Flashcards.
 */
public class FlashcardDeck {
    // Attributes
    final ArrayList<Flashcard> flashcardDeck = new ArrayList<>();
    private int currentIdx = -1; // idx before the fisrt card

    // Constructor: start empty
    public FlashcardDeck() {
    }

    public void addFlashcard(Flashcard flashcard) {
        flashcardDeck.add(flashcard);
    }


    public Flashcard getNextflashcard() {
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


}     

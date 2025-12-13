/*
 * This is FlashcardTest class.
 */
package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/* Flashcard test for testing Flashcard related methods.
 */
public class FlashcardTest {

    // Test if card can get correct question.
    @Test
    void testGetQuestion() {
        Flashcard fc = new Flashcard("Hi in Swedish?", "Hej");
        assertEquals("Hi in Swedish?", fc.getQuestion());
    }

    // Test if card can get correct question.
    @Test
    void testGetAnswer() {
        Flashcard fc = new Flashcard("Goodbye in Swedish?", "Hej då");
        assertEquals("Hej då", fc.getAnswer());
    }
}

/*
 * This is FlashcardTest class.
 */
package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class FlashcardTest {

    @Test
    void testGetQuestion() {
        Flashcard fc = new Flashcard("Hi in Swedish?", "Hej");
        assertEquals("Hi in Swedish?", fc.getQuestion());
    }

    @Test
    void testGetAnswer() {
        Flashcard fc = new Flashcard("Goodbye in Swedish?", "Hej då");
        assertEquals("Hej då", fc.getAnswer());
    }
}

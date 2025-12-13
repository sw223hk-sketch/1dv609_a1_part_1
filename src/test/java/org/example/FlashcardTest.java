/*
 * This is FlashcardTest class.
 */
package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/* Flashcard test for testing Flashcard related methods.
 */
public class FlashcardTest {

    // Test if card can get correct question.
    @Test
    void testQuestionShouldBeCorrect() {
        Flashcard fc = new Flashcard("Hi in Swedish?", "Hej");
        assertEquals("Hi in Swedish?", fc.getQuestion());
    }

    // Test if card can get correct question.
    @Test
    void testAnswerShouldBeCorrect() {
        Flashcard fc = new Flashcard("Goodbye in Swedish?", "Hej då");
        assertEquals("Hej då", fc.getAnswer());
    }

    // Test if card can contain both question and answer.
    @Test
    void testContainQuestionAndAnswer() {
        Flashcard fc = new Flashcard("What did you eat for breakfast in Swedish?", "Vad åt du till frukost?");

        // Store toString() in result
        String result = fc.toString();

        // Return true if toString() contains correct question and answer
        assertTrue(result.contains(fc.getQuestion()));
        assertTrue(result.contains(fc.getAnswer()));
    }
}

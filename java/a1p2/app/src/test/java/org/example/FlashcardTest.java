/*
 * This is FlashcardTest class.
 */
package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class FlashcardTest {

    @Test
    void testGetQuestion() {
        Flashcard fc = new Flashcard("Hi in Swedish?", "Hej");
        assertEquals("Hi in Swedish?", fc.getQuestion());
    }

    

}

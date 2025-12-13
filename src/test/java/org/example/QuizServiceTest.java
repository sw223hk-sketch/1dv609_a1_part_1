package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class QuizServiceTest {

    // Returns for next card from FlashcardDeck, and question should be correct(the same as without Service).
    @Test
    void testReturnedQuestion() {
        // 1. Set up mock
        FlashcardDeck mockFcDeck = Mockito.mock(FlashcardDeck.class);
        Flashcard mockFc = new Flashcard("No problem in Swedish?", "Inga problem");

        // Expected Behavior: tell mock to return mockFc when call from mockFcDeck
        when(mockFcDeck.getNextFlashcard()).thenReturn(mockFc);

        // 2. Run quizService to verify behavior
        QuizService service = new QuizService();
        service.setFlashcardDeck(mockFcDeck);

        Flashcard returnedCard = service.getReturnedFlashcard();

        // Check if question from returnedCard is the same as mockFc
        assertEquals("No problem in Swedish?", returnedCard.getQuestion());

        // Verify that FlashcardDeck is called only once
        verify(mockFcDeck, times(1)).getNextFlashcard();
    }

    // Returns for next card from FlashcardDeck
    @Test
    void testCheckAnswerCorrect() {
        // Set up mock
        FlashcardDeck mockFcDeck = Mockito.mock(FlashcardDeck.class);
        Flashcard mockFc = new Flashcard("Why in Swedish?", "Varför?");

        // Expected Behavior: tell mock to return mockFc when call from mockFcDeck
        when(mockFcDeck.getNextFlashcard()).thenReturn(mockFc);

        // 2. Run quizService to verify behavior
        QuizService service = new QuizService();
        service.setFlashcardDeck(mockFcDeck);

        Flashcard returnCard = service.getReturnedFlashcard();

        // Check if answer from returnedCard is the same as mockFc
        assertTrue(returnCard.checkAnswer(mockFc, "Varför"));

        // Verify that FlashcardDeck is called only once
        verify(mockFcDeck, times(1)).getNextFlashcard();

    }
}

package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class QuizServiceTest {

    // Returns for next card from FlashcardDeck
    @Test
    void testReturnCardQuestion() {
        // 1. Set up mock
        FlashcardDeck mockFcDeck = Mockito.mock(FlashcardDeck.class);
        Flashcard mockFc = new Flashcard("No problem in Swedish?", "Inga problem");

        // Behavior: Tell mock to return mockFc when call from mockFcDeck
        when(mockFcDeck.getNextFlashcard()).thenReturn(mockFc);

        // 2. Run quizService to verify behavior
        QuizService service = new QuizService(mockFcDeck);

        Flashcard returnedCard = service.retrieveQuestion();

        // Check if question from returnedCard is the same as mockFc
        assertEquals(mockFc.getQuestion(), returnedCard.getQuestion());

        // Verify that FlashcardDeck is called only once
        verify(mockFcDeck, times(1)).getNextFlashcard();
    }
}

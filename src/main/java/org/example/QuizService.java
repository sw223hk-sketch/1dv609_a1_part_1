package org.example;

/* User use the App through QuizService.
 */
public class QuizService {

    //Attributes 
    private FlashcardDeck flashcardDeck = new FlashcardDeck();

    public void setFlashcardDeck(FlashcardDeck flashcardDeck) {
        this.flashcardDeck = flashcardDeck;
    }

    //Get returned flashcard from FlashcardDeck through QuizService 
    public Flashcard getReturnedFlashcard() {
        return flashcardDeck.getNextFlashcard();
    }

    //Get returned question from flashcard through QuizService
    public String getReturnedQuestion() {
        Flashcard card = getReturnedFlashcard(); //save returnedCard in card
        return card.getQuestion();
    }

}

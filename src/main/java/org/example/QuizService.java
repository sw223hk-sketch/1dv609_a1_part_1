package org.example;

/* User use the App through QuizService.
 */
public class QuizService {

    //Attributes 
    private FlashcardDeck flashcardDeck = new FlashcardDeck();
    private User user = new User(null, 0);

    public void setFlashcardDeck(FlashcardDeck flashcardDeck) {
        this.flashcardDeck = flashcardDeck;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setScore(int score) {
        user.setScore(score);
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

    //Get returned score from user through QuizService
    public User getReturnedUser() {
        return user;
    }

    //Get returned score from user through QuizService
    public int getReturnedScore() {
        return user.getScore();
    }

    //Get returned question from card through QuizService and compapre to the answer without
    //passing the service
    public boolean checkAnswer(Flashcard card, String userAnswer) {
        return card.getAnswer().equals(userAnswer);
    }

    //Get returned question from card through QuizService and compapre to the answer without
    //passing the service
    public boolean checkScore(User user, int userScore) {
        return user.getScore() == userScore;
    }
}

package org.example;
/* Flashcards consists of Flashcard
 */
public class Flashcard {
    //Attributes
    private String question;
    private String answer;

    //Constructor
    public Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
    //Methods
    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}

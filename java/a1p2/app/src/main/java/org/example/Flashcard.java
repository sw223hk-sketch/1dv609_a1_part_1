package org.example;

public class Flashcard {
    //Attributes
    public String question;
    public String answer;

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

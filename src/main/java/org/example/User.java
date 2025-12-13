package org.example;

/* Users that use the App to play quiz.
 */
public class User {

    // Attributes
    private String userName;
    private int score;

    // Constructor
    public User(String userName, int score) {
        this.userName = userName;
        this.score = score;
    }

    // Method
    public void setName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setsScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}

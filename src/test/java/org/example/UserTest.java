package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void testGetUserName() {
        User user = new User("Sally", 2);
        assertEquals("Sally", user.getUserName());

    }

    @Test
    void testUserShouleGetCorrectScore() {
        User user = new User("Jack", 30);
        assertEquals(30, user.getScore());
    }

    /* Scores should not be negative.
     */
    @Test
    void userShouldNotAllowNegativeScore() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("John", -1)
        );

    }

    // Test if set user name works correctly
    @Test
    void testSetNameCorrectly() {
        User user = new User("Emily", 13);
        user.setUserName("Kelly");
        assertEquals("Kelly", user.getUserName());
    }

    // Test if set user name works correctly
    @Test
    void testSetScoreCorrectly() {
        User user = new User("Ashley", 11);
        user.setScore(20);
        assertEquals(20, user.getScore());
    }
}

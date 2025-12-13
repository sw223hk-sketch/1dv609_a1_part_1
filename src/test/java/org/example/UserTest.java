package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void testGetUserName() {
        User user = new User("Sally", 2);
        assertEquals("Sally", user.getUserName());

    }

    @Test
    void testgetScore() {
        User user = new User("Jack", 30);
        assertEquals(30, user.getScore());
    }
}

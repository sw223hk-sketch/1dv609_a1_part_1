package com.lab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Password implementations.
 * 
 * To test different buggy versions, simply uncomment the corresponding
 * getPassword() method and comment out the others.
 * 
 * Available implementations:
 * - Password: Correct implementation
 * - BugDoesNotTrim: Does not trim whitespace
 * - BugToShortPassword: Allows passwords shorter than 12 characters
 * - BugVeryShort: Allows way to short passwords
 * - BugWrongExceptionMessage: Wrong exception message for short passwords
 * - BugMissingPasswordLengthCheck: Does not throw exception for short passwords
 * - BugMissingNumberCheck: Does not throw exception if password lacks a number
 * - BugIsPasswordSameAlwaysTrue: isPasswordSame always returns true
 * - BugWrongHashingAlgorithm: Wrong hashing algorithm
 */

public class PasswordTest {
    private IPassword getPassword(String s) throws Exception {
           return (IPassword) new Password(s);
        // return (IPassword) new BugDoesNotTrim(s);
        // return (IPassword) new BugToShortPassword(s);
        // return (IPassword) new BugVeryShort(s);
        // return (IPassword) new BugWrongExceptionMessage(s);
        // return (IPassword) new BugMissingPasswordLengthCheck(s);
        // return (IPassword) new BugMissingNumberCheck(s);
        // return (IPassword) new BugIsPasswordSameAlwaysTrue(s);
        // return (IPassword) new BugWrongHashingAlgorithm(s);
    }

    @Test
    public void shouldAlwaysPass() throws Exception {
        assertTrue(true);
    }

    // Test BugsDoesNotTrime(s), should trim space in the begining, middle or end of password
    @Test
    public void shouldTrimWhitespace() throws Exception {
        BugDoesNotTrim password = new BugDoesNotTrim(" long password14 "); 
        assertEquals("longpassword14", password.getTrimmedPassword()); //length = 14
    }

    // Test BugToShortPassword(s), throw an exception when password length < 11
    @Test 
    public void passwordShorterThanEleven() throws Exception {
        assertThrows(Exception.class, 
            () -> {
                new BugToShortPassword("password12"); // length = 10
            }
        );
    }

    // Test BugVeryShort(String pw), throw an exception when password length < 6
    @Test
    public void passwordShorterThanSix() throws Exception {
        assertThrows(Exception.class,
            () -> {
                new BugVeryShort("pass1"); // length = 5
            }
        );
    }

}
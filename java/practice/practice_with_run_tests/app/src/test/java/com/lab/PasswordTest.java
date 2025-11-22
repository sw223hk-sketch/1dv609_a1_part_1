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
        // return (IPassword) new Password(s);
        // return (IPassword) new BugDoesNotTrim(s);
        // return (IPassword) new BugToShortPassword(s);
        // return (IPassword) new BugVeryShort(s);
        // return (IPassword) new BugWrongExceptionMessage(s);
        // return (IPassword) new BugMissingPasswordLengthCheck(s);
           return (IPassword) new BugMissingNumberCheck(s);
        // return (IPassword) new BugIsPasswordSameAlwaysTrue(s);
        // return (IPassword) new BugWrongHashingAlgorithm(s);
    }

    @Test
    public void shouldAlwaysPass() throws Exception {
        assertTrue(true);
    }

    // Test BugsDoesNotTrime(s), does not trim space in the begining or at the end of password
    @Test
    public void doesNotTrimWhitespace() throws Exception {
        assertNotEquals("longPasswor1", new BugDoesNotTrim(" longPasswor1 ")); //length = 12
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

    // Test BugVeryShort(String pw), pass test if password length < 6
    @Test
    public void passwordShorterThanSix() throws Exception {
        assertThrows(Exception.class,
            () -> {
                new BugVeryShort("pass1"); // length = 5
            }
        );
    }

   // Test BugRunExceptionMessage(), pass test if the message is wrong, not equal to correct message
   @Test 
   public void wrongExceptionMessage() throws Exception {
        Exception ex = assertThrows (
            Exception.class, 
            () -> new BugWrongExceptionMessage("short") // Wrong message
        );

       assertNotEquals("To short password", ex.getMessage()); // Check if correct and wrong messages are equal
   }
       
   // Test BugMissingPasswordLength(), pass test if fail to check length(<12)
   @Test
   public void passwordLengthCheckMissing() throws Exception {
        BugMissingPasswordLengthCheck password = new BugMissingPasswordLengthCheck("password1"); // contain a number to meet another condition, but short
        assertNotNull(password); // password is created with unchecked length, which means password not null
   }

   // Test BugMissingNumberCheck(), pass test if fail to check password contains number
   @Test
   public void passwordNumberCheckMissing() throws Exception {
        BugMissingNumberCheck password = new BugMissingNumberCheck("longpassword"); // length should be > 12 but without a number
        assertNotNull(password); // password created without if contain numbers check
   }
}
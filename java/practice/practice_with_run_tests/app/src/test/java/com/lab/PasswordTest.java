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
         //  return (IPassword) new BugDoesNotTrim(s);
         //return (IPassword) new BugToShortPassword(s);
        // return (IPassword) new BugVeryShort(s);
         //return (IPassword) new BugWrongExceptionMessage(s);
         //return (IPassword) new BugMissingPasswordLengthCheck(s);
        // return (IPassword) new BugMissingNumberCheck(s);
         //return (IPassword) new BugIsPasswordSameAlwaysTrue(s);
         return (IPassword) new BugWrongHashingAlgorithm(s);
    }

    @Test
    public void shouldAlwaysPass() throws Exception {
        assertTrue(true);
    }

    // Test BugsDoesNotTrim(s), throw exception if does not trim space in the begining or at the end of password
    @Test
    public void shouldThrowExceptionOnNotTrimWhitespace() throws Exception {
        assertNotEquals("longPasswor1", new BugDoesNotTrim(" longPasswor1 ")); //length = 12

        //Buggy pw that passes all tests
        assertNotEquals("000000000000", new BugDoesNotTrim(" 000000000000 ")); //too simple pw

    }


    // Test BugToShortPassword(s), throw an exception when password length < 11
    /*@Test 
    public void shouldThrowExceptionOnPasswordShorterThanEleven() throws Exception {
        assertThrows(Exception.class, 
            () -> {
                new BugToShortPassword("password12"); // length = 10
            }
        );
    }*/

    // Test BugVeryShort(String pw), pass test if password length < 6
    /*@Test
    public void shouldThrowExceptionOnPasswordShorterThanSix() throws Exception {
        assertThrows(Exception.class,
            () -> {
                new BugVeryShort("pass1"); // length = 5
            }
        );
    }*/

   // Test BugWrongExceptionMessage(), pass test if the message is wrong, not equal to correct message
   @Test 
   public void shouldThrowExceptionOnWrongExceptionMessage() throws Exception {
        Exception ex = assertThrows (
            Exception.class, 
            () -> new BugWrongExceptionMessage("00000000000") // Wrong message
        );

        assertNotEquals("To short password", ex.getMessage()); // Check if correct and wrong messages are equal

   }
       
   // Test BugMissingPasswordLength(), exception thrown for short passwords
   @Test
   public void shouldThrowExceptionOnPasswordWithoutLengthChecking() {
        assertDoesNotThrow(() -> new BugMissingPasswordLengthCheck("00000000000")); //Since no length check, length = 11 should not throw "To short pw" exception
    }

   

   // Test BugMissingNumberCheck(), pass test if fail to check password contains number
   @Test
   public void shouldThrowExceptionOnPasswordWithoutNumber() throws Exception {
        BugMissingNumberCheck password = new BugMissingNumberCheck("longpassword"); // length should be > 12 but without a number
        assertNotNull(password); // password created without if contain numbers check

        //Buggy pw that passes all tests
        /*BugMissingNumberCheck simplePassword = new BugMissingNumberCheck("00000000000");  // fail on length = 11, it triggers an exception
        assertNotNull(simplePassword);*/
   }

   // Test BugIsPasswordSameAlwaysTrue(), pass test if true -- different passwords shows same result
   @Test
   public void shouldThrowExceptionOnPasswordSameAlwaysTrue() throws Exception {
        BugIsPasswordSameAlwaysTrue password1 = new BugIsPasswordSameAlwaysTrue("password1234"); // create 2 different passwords
        BugIsPasswordSameAlwaysTrue password2 = new BugIsPasswordSameAlwaysTrue("password5678");

        assertTrue(password1.isPasswordSame(password2)); // compare if they are the same, it shows true

        //Buggy pw that passes all tests
        BugIsPasswordSameAlwaysTrue simplePassword = new BugIsPasswordSameAlwaysTrue("abcdefghijk1"); 
        assertTrue(password1.isPasswordSame(simplePassword));
   }

   // Test BugWrongHashingAlgorithm(s), pass test if -- different passwords have same hash value
   @Test
   public void shouldThrowExceptionOnWrongHashingAlgorithm() throws Exception {
        BugWrongHashingAlgorithm password1 = new BugWrongHashingAlgorithm("abcd12345678"); // algorithm is collision prone
        BugWrongHashingAlgorithm password2 = new BugWrongHashingAlgorithm("87654321dcba"); 
        
        assertEquals(password1.getPasswordHash(), password2.getPasswordHash()); // different pw supposed to have different hash values

        BugWrongHashingAlgorithm simplePassword = new BugWrongHashingAlgorithm("000000000000"); //Buggy pw that passes all tests
        BugWrongHashingAlgorithm password4 = new BugWrongHashingAlgorithm("500000000005"); 

        assertEquals(simplePassword.getPasswordHash(), password4.getPasswordHash());
   }
}
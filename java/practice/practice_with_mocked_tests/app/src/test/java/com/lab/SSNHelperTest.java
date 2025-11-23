package com.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class SSNHelperTest { 

    private SSNHelper helper;
    
    @BeforeEach
    public void setUp() {
        helper = new SSNHelper();  //use SSN helper
    }
    /* TEST DAY
     */
    //Buggy helper should reject day 31
    @Test
    public void buggyHelperShouldRejectDay31() {
        BuggySSNHelperAllowDayUpTo30 buggyHelper = new BuggySSNHelperAllowDayUpTo30();
        assertFalse(buggyHelper.isValidDay("31"), "Buggy helper should reject day 31");
    }

    //Correct helper should accept day 31
    @Test
    public void correctHelperShouldAcceptDay31() {
        assertTrue(helper.isValidDay("31"));
    }

    /* TEST MONTH
     */
    //Buggy helper should allow month 0
    @Test
    public void buggyHelperShouldAllowMonth0() {
        BuggySSNHelperAllowMonth0 buggyHelper = new BuggySSNHelperAllowMonth0();
        assertTrue(buggyHelper.isValidMonth("00"), "Buggy helper should accept month 0");
    }

    //Correct helper should reject month 0
    @Test
    public void correctHelperShouldRejectMonth0() {
        assertFalse(helper.isValidMonth("00"), "Correct helper should reject month 0");
    }

    /* TEST INCORRECT FORMAT
     */
    //Buggy helper should accept incorrect format
    @Test
    public void buggyHelperShouldAllowIncorrectFormat() {
        BuggySSNHelperIncorrectFormat buggyHelper = new BuggySSNHelperIncorrectFormat();
        // Correct format eg. 900031-1234
        assertTrue(buggyHelper.isCorrectFormat("900101-00178"), "Buggy helper should accept incorrect format");
    }

    //Correct helper should reject incorrect format
    @Test
    public void correctHelperShouldRejectIncorrectFormat() {
        // Correct format eg. 900031-1234
        assertFalse(helper.isCorrectFormat("900101-00178"), "Correct helper should reject incorrect format");
    }

    /* TEST CORRECT FORMAT
     */
    //Buggy helper should reject correct format
    @Test
    public void buggyHelperShouldRejectCorrectFormat() {
        BuggySSNHelperIncorrectFormatFalse buggyHelper = new BuggySSNHelperIncorrectFormatFalse();
        // Correct format eg. 900031-1234
        assertFalse(buggyHelper.isCorrectFormat("900101-0017"), "Buggy helper should reject correct format");
    }

    //Correct helper should accept correct format
    @Test
    public void correctHelperShouldAcceptCorrectFormat() {
        assertTrue(helper.isCorrectFormat("900101-0017"), "Correct helper should reject correct format");
    }

    /* TEST MESSY LUHN
     */
    //Buggy helper should accept messy Luhn algorithm
    @Test
    public void buggyHelperShouldAcceptMessyLuhn() {
        BuggySSNHelperMessyLuhn buggyHelper = new BuggySSNHelperMessyLuhn();
        //Correct ssn is 900101-0017
        assertTrue(buggyHelper.luhnIsCorrect("900101-2346"), "Buggy helper should accept messy Luhn");
    }

    //Correct helper should reject incorrect Luhn algorithm
    @Test
    public void correctHelperShouldRejectMessyLuhn() {
        assertFalse(helper.luhnIsCorrect("900101-2346"), "Correct helper should reject messy Luhn");
    }

    /* TEST WRONG LENGTH
     */
    //Buggy helper should accept wrong length(>11)
    @Test
    public void buggyHelperShouldAcceptWrongLength() {
        BuggySSNHelperWrongLength buggyHelper = new BuggySSNHelperWrongLength();
        assertTrue(buggyHelper.isCorrectLength("900101-00170")); // should be == 11
    }

}

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
    
    //Buggy helper should reject day 31
    @Test
    public void buggyHelperShouldRejectDay31() {
        BuggySSNHelperAllowDayUpTo30 buggyHelper = new BuggySSNHelperAllowDayUpTo30();
        assertFalse(buggyHelper.isValidDay("31"), "Buggy helper should reject day 31");
    }

    //Buggy helper should reject month 0
    @Test
    public void buggyHelperShouldAllowMonth0() {
        BuggySSNHelperAllowMonth0 buggyHelper = new BuggySSNHelperAllowMonth0();
        assertTrue(buggyHelper.isValidMonth("0"), "Buggy helper should accept month 0");
    }

    //Buggy helper should reject incorrect format
    @Test
    public void buggyHelperShouldAllowIncorrectFormat() {
        BuggySSNHelperIncorrectFormat buggyHelper = new BuggySSNHelperIncorrectFormat();
        // Correct format eg. 900031-1234
        assertFalse(buggyHelper.isCorrectFormat("9000311234"), "Buggy helper should accept incorrect format");
    }
}

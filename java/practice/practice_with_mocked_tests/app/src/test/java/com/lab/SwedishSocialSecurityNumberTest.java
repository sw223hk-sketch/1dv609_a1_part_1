package com.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SwedishSocialSecurityNumberTest {
    
    private SSNHelper mockHelper;
    
    @BeforeEach
    public void setUp() {
        mockHelper = mock(SSNHelper.class); // create a fake object to work for
    }
    
    @Test
    public void shouldAcceptValidSSN() throws Exception {
        // When MockHelper works
        when(mockHelper.isCorrectLength("900101-0017")).thenReturn(true);
        when(mockHelper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(mockHelper.isValidMonth("01")).thenReturn(true);
        when(mockHelper.isValidDay("01")).thenReturn(true);
        when(mockHelper.luhnIsCorrect("900101-0017")).thenReturn(true);
        
        SwedishSocialSecurityNumber ssn = new SwedishSocialSecurityNumber("900101-0017", mockHelper);
        
        assertEquals("90", ssn.getYear());
        assertEquals("01", ssn.getMonth());
        assertEquals("01", ssn.getDay());
        assertEquals("0017", ssn.getSerialNumber());
    }
    

    //  Correct mockHelper should accept day 31
    @Test
    public void shouldAcceptValidDay() throws Exception {
        // MockHelper works
        when(mockHelper.isCorrectLength("900131-1234")).thenReturn(true);
        when(mockHelper.isCorrectFormat("900131-1234")).thenReturn(true);
        when(mockHelper.isValidMonth("01")).thenReturn(true);
        when(mockHelper.isValidDay("31")).thenReturn(true);
        when(mockHelper.luhnIsCorrect("900131-1234")).thenReturn(true);

        SwedishSocialSecurityNumber ssn = new SwedishSocialSecurityNumber("900131-1234", mockHelper);

        // Verify mock methods is called and day 31 is verified
        verify(mockHelper).isValidDay("31"); 
    }

    // Correct mockHelper should accpect month 0
    @Test 
    public void shouldAcceptValidMonth() throws Exception {
        // MockeHelper works
        when(mockHelper.isCorrectLength("900031-1234")).thenReturn(true);
        when(mockHelper.isCorrectFormat("900031-1234")).thenReturn(true);
        when(mockHelper.isValidMonth("00")).thenReturn(true);
        when(mockHelper.isValidDay("31")).thenReturn(true);
        when(mockHelper.luhnIsCorrect("900031-1234")).thenReturn(true);

        // Create new SSN, pass by mockHelper
        SwedishSocialSecurityNumber ssn = new SwedishSocialSecurityNumber("900031-1234", mockHelper);

        // Verify mock methods is called and month 0 is verified
        verify(mockHelper).isValidMonth("00");
    }

    // Correct mockHelper should accept incorrect format 
    @Test 
    public void shouldRejectIncorrectFormat() throws Exception {
        // MockeHelper works
        when(mockHelper.isCorrectLength("900101-00178")).thenReturn(true);
        when(mockHelper.isCorrectFormat("900101-00178")).thenReturn(true);
        when(mockHelper.isValidMonth("01")).thenReturn(true);
        when(mockHelper.isValidDay("01")).thenReturn(true);
        when(mockHelper.luhnIsCorrect("900101-00178")).thenReturn(true);

        // Create new SSN, pass by mockHelper
        SwedishSocialSecurityNumber ssn = new SwedishSocialSecurityNumber("900101-00178", mockHelper);

        // Verify mock methods is called and format is verified
        verify(mockHelper).isCorrectFormat("900101-00178");
    }

    // Correct mockHelper should accepct correct format 
    @Test 
    public void shouldAcceptCorrectFormat() throws Exception {
        // MockeHelper works
        when(mockHelper.isCorrectLength("900101-0017")).thenReturn(true);
        when(mockHelper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(mockHelper.isValidMonth("01")).thenReturn(true);
        when(mockHelper.isValidDay("01")).thenReturn(true);
        when(mockHelper.luhnIsCorrect("900101-0017")).thenReturn(true);

        // Create new SSN, pass by mockHelper
        SwedishSocialSecurityNumber ssn = new SwedishSocialSecurityNumber("900101-0017", mockHelper);

        // Verify mock methods is called and format is verified
        verify(mockHelper).isCorrectFormat("900101-0017");
    }

    // Correct mockHelper should accept messy Luhn algorithm
    @Test
    public void shouldAcceptMessyLugn() throws Exception {
        // MockeHelper works
        when(mockHelper.isCorrectLength("900101-2346")).thenReturn(true);
        when(mockHelper.isCorrectFormat("900101-2346")).thenReturn(true);
        when(mockHelper.isValidMonth("01")).thenReturn(true);
        when(mockHelper.isValidDay("01")).thenReturn(true);
        when(mockHelper.luhnIsCorrect("900101-2346")).thenReturn(true);

        // Create new SSN, pass by mockHelper
        SwedishSocialSecurityNumber ssn = new SwedishSocialSecurityNumber("900101-2346", mockHelper);

        // Verify mock methods is called and format is verified
        verify(mockHelper).luhnIsCorrect("900101-2346");
    }

    // Correct mockHelper should accept wrong length
    @Test
    public void shouldAcceptWrongLength() throws Exception {
        // MockeHelper works
        when(mockHelper.isCorrectLength("900101-00170")).thenReturn(true);
        when(mockHelper.isCorrectFormat("900101-00170")).thenReturn(true);
        when(mockHelper.isValidMonth("01")).thenReturn(true);
        when(mockHelper.isValidDay("01")).thenReturn(true);
        when(mockHelper.luhnIsCorrect("900101-00170")).thenReturn(true);

        // Create new SSN, pass by mockHelper
        SwedishSocialSecurityNumber ssn = new SwedishSocialSecurityNumber("900101-00170", mockHelper);

        // Verify mock methods is called and length is verified
        verify(mockHelper).isCorrectLength("900101-00170");
    }

    // Correct mockHelper should accept no length check
    @Test
    public void shouldAcceptNoLengthCheck() throws Exception {
        // MockeHelper works
        when(mockHelper.isCorrectLength("900101-001")).thenReturn(true);
        when(mockHelper.isCorrectFormat("900101-001")).thenReturn(true);
        when(mockHelper.isValidMonth("01")).thenReturn(true);
        when(mockHelper.isValidDay("01")).thenReturn(true);
        when(mockHelper.luhnIsCorrect("900101-001")).thenReturn(true);

        // Create new SSN, pass by mockHelper
        SwedishSocialSecurityNumber ssn = new SwedishSocialSecurityNumber("900101-001", mockHelper);

        // Verify mock methods is called and length is verified
        verify(mockHelper).isCorrectLength("900101-001");
    }
}
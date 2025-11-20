package com.lab;

// Buggy 1: Does not trim whitespace
class BugDoesNotTrim implements IPassword {
    protected int passwordHash;
    private String trimmedPassword; // trimmed password for testing
    
    // Trim white space, check length (>12), and contain a number
    public BugDoesNotTrim(String pw) throws Exception {
        // Bug: Don't trim whitespace
        String trimmed_password = pw.replaceAll("\\s", ""); // remove all space 

        if (isToShort(trimmed_password)) {
            throw new Exception("To short password");
        }
        if (containsNumber(trimmed_password) == false) {
            throw new Exception("Does not contain a number");
        }
        this.passwordHash = simpleHash(trimmed_password); // store hash value of pw in passwordHash 
        this.trimmedPassword = trimmed_password; // stores trimmed_password in trimmed_pw
    }
    
    private int simpleHash(String input) {
        int hash = 7;
        for (int i = 0; i < input.length(); i++) {
            hash = hash * 31 + input.charAt(i);
        }
        return hash;
    }
    
    private boolean isToShort(String pw) {
        return pw.length() < 12;
    }
    
    private boolean containsNumber(String text) {
        return text.matches(".*\\d.*");
    }
    
    public int getPasswordHash() {
        return this.passwordHash;
    }


    public String getTrimmedPassword() {
        return trimmedPassword;
    }
    
    public boolean isPasswordSame(IPassword other) {
        return this.passwordHash == other.getPasswordHash();
    }
}
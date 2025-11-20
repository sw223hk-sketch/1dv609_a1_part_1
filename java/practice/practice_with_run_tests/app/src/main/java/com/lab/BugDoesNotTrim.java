package com.lab;

// Buggy 1: Does not trim whitespace
class BugDoesNotTrim implements IPassword {
    protected int passwordHash;
    private String trimmed_pw; // trimmed password for testing
    
    // Trim white space, check length (>12), and contain a number
    public BugDoesNotTrim(String pw) throws Exception {
        // Bug: Don't trim whitespace
        String trimmed_pw = pw.replaceAll("\\s", ""); //remove all space

        if (isToShort(trimmed_pw)) {
            throw new Exception("To short password");
        }
        if (containsNumber(trimmed_pw) == false) {
            throw new Exception("Does not contain a number");
        }
        this.passwordHash = simpleHash(trimmed_pw);
        this.trimmed_pw = trimmed_pw;
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
        return trimmed_pw;
    }
    
    public boolean isPasswordSame(IPassword other) {
        return this.passwordHash == other.getPasswordHash();
    }
}
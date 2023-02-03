package com.techelevator.model;

public class FamilyUsers {
    private String familyName;
    private int familyId;
    private String username;

    public FamilyUsers(String familyName, int familyId, String username) {
        this.familyName = familyName;
        this.familyId = familyId;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public FamilyUsers() {
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }



    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }
}


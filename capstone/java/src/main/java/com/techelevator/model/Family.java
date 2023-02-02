package com.techelevator.model;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class Family {
    private String familyName;
    private List<User> familyUsers = new ArrayList<>();
    private int familyId;

    public Family(String familyName, List<User> familyUsers, int familyId) {
        this.familyName = familyName;
        this.familyUsers = familyUsers;
        this.familyId = familyId;
    }

    public Family() {
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public List<User> getFamilyMembers() {
        return familyUsers;
    }

    public void setFamilyMembers(List<User> familyUsers) {
        this.familyUsers = familyUsers;
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }
}


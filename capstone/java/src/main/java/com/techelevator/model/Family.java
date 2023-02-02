package com.techelevator.model;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class Family {
    private String familyName;
    private List<Members> familyMembers = new ArrayList<>();
    private int familyId;

    public Family(String familyName, List<Members> familyMembers, int familyId) {
        this.familyName = familyName;
        this.familyMembers = familyMembers;
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

    public List<Members> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(List<Members> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }
}


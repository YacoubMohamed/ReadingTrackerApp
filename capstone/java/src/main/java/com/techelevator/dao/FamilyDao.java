package com.techelevator.dao;

import com.techelevator.model.Family;
import com.techelevator.model.User;
import com.techelevator.model.FamilyUsers;

import java.util.List;

public interface FamilyDao {
    List<FamilyUsers> getListOfFamilyMembers(int familyId);
    List<Family> getListOfFamilies();
    Family getFamilyById(int familyId);
    int findByUsername(String username);
    void addFamily (Family newFamily );
    void deleteFamily (int familyId);
    void updateFamily ();
    void addFamilyMember (int userId, int familyId);
    void findAllUsers ();



}

package com.techelevator.dao;

import com.techelevator.model.Family;
import com.techelevator.model.User;

import java.util.List;

public interface FamilyDao {
    List<Family> getListOfFamilies();

    Family getFamilyById(int familyId);

    Family findByUsername(String username);
    void addFamily (Family newFamily );
    void deleteFamily (Family familyId);
    void updateFamily ();



}

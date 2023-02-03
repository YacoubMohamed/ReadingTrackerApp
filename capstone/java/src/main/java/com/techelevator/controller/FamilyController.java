package com.techelevator.controller;

import com.techelevator.dao.FamilyDao;
import com.techelevator.model.Family;
import com.techelevator.model.FamilyUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FamilyController {

    @Autowired
    private FamilyDao familyDao;

    @RequestMapping(path = "/addFamily", method = RequestMethod.POST)
    public void addFamily(@RequestBody Family newFamily) {
        familyDao.addFamily(newFamily);
}
    @RequestMapping(path = "/family/{id}")
    public List<FamilyUsers> getListOfFamilyMembers(int familyId) {
        return familyDao.getListOfFamilyMembers(familyId);
    }
    @RequestMapping(path = "/family/{familyId}/{userId}", method = RequestMethod.PUT)
    public void addFamilyMember(int userId, int familyId) {
        familyDao.addFamilyMember(userId,familyId);
    }
    }

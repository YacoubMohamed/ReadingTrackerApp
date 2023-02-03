package com.techelevator.controller;

import com.techelevator.dao.FamilyDao;
import com.techelevator.model.Family;
import com.techelevator.model.FamilyUsers;
import com.techelevator.model.FamilyUpdateDto;
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

    @RequestMapping(path = "/deleteFamily/{familyId}", method = RequestMethod.PUT)
    public void deleteFamily(@PathVariable int familyId) {
        familyDao.deleteFamily(familyId);
    }

    @RequestMapping(path = "/updateFamily/{familyId}", method = RequestMethod.PUT)
    public void updateFamily(@RequestBody FamilyUpdateDto familyName, @PathVariable int familyId) {
        familyDao.updateFamily(familyName.getFamilyName(), familyId);
    }

    @RequestMapping(path = "/family/list/{familyId}")
    public List<FamilyUsers> getListOfFamilyMembers(int familyId) {
        return familyDao.getListOfFamilyMembers(familyId);
    }

    @RequestMapping(path = "/family/{familyId}/{userId}", method = RequestMethod.PUT)
    public void addFamilyMember(@PathVariable int userId, @PathVariable int familyId) {
        familyDao.addFamilyMember(userId, familyId);
    }

    @RequestMapping(path = "/family")
    public List<Family> getListOfFamilies() {
        return familyDao.getListOfFamilies();
    }

    @RequestMapping(path = "/family/{userId}")
    public int getFamilyByUserId(@PathVariable int userId) {
        return familyDao.getFamilyByUserId(userId);
    }
}
   // @RequestMapping (path = "/family/{familyId}")
   // public Family getFamilyNameByFamilyId (@PathVariable int familyId) {
       // return familyDao.getFamilyById(familyId);
   // }

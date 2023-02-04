package com.techelevator.controller;

import com.techelevator.dao.FamilyDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Family;
import com.techelevator.model.FamilyUsers;
import com.techelevator.model.FamilyUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class FamilyController {

    @Autowired
    private FamilyDao familyDao;
    @Autowired
    private UserDao userDao;
    @RequestMapping(path = "/addFamily", method = RequestMethod.POST)
    public void addFamily(@RequestBody Family newFamily, Principal principal) {
        System.out.println(principal.getName());
        int id = userDao.findIdByUsername(principal.getName());
        newFamily.setUserId(id);
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

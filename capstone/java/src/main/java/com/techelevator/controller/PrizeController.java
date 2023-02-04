package com.techelevator.controller;


import com.techelevator.dao.PrizeDao;
import com.techelevator.model.Book;
import com.techelevator.model.Family;
import com.techelevator.model.Prize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PrizeController {

    @Autowired
    private PrizeDao prizeDao;

    @RequestMapping(path = "/addFamilyPrize", method = RequestMethod.POST)
    public void addPrizeToFamily(@RequestBody Prize newPrize) {
        prizeDao.addPrizeToFamily(newPrize);
    }

    @RequestMapping(path = "/addUserPrize", method = RequestMethod.POST)
    public void addPrizeToUser(@RequestBody Prize newPrize) {
        prizeDao.addPrizeToUser(newPrize);
    }

    @RequestMapping(path = "/prizes/list/user/{userId}")
    public List<Prize> getAllPrizesByUserId(@PathVariable int userId) {
        return prizeDao.getAllPrizesByUserId(userId);

    }

    @RequestMapping(path = "/prizes/prize/{prizeId}")
    public Prize getPrizesById(@PathVariable int prizeId) {
        Prize prize = prizeDao.getPrizesById(prizeId);
        return prize;
    }

    @RequestMapping(path = "/prizes/list/family/{familyId}")
    public List<Prize> getAllPrizesByFamilyId(@PathVariable int familyId) {
        return prizeDao.getAllPrizesByFamilyId(familyId);
    }

    @RequestMapping(path = "/deletePrize/{prizeId}", method = RequestMethod.DELETE)
    public void deletePrize(@PathVariable int prizeId) {
        prizeDao.deletePrize(prizeId);
    }

    @RequestMapping(path = "/updatePrize/{prizeId}", method = RequestMethod.PUT)
    public void updatePrize(@PathVariable int prizeId) {
        prizeDao.updatePrize(getPrizesById(prizeId));
    }
}
package com.techelevator.controller;

import com.techelevator.dao.FamilyDao;
import com.techelevator.dao.ReadingActivityDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.ReadingActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ReadingActivityController {

    @Autowired
    private ReadingActivityDao readingActivityDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private FamilyDao familyDao;

    @RequestMapping(path = "/activities")
    public List<ReadingActivity> getAllReadingActivities() {
        List<ReadingActivity> activityList = readingActivityDao.getAllReadingActivities();
        return activityList;
    }

    @RequestMapping(path = "/activities/user/{userId}")
    public int getReadingTimeByUserId (@PathVariable int userId){
        return readingActivityDao.getReadingTimeByUserId(userId);
    }

    @RequestMapping(path = "/activities/family/{familyId}")
    public int getReadingTimeByFamilyId (@PathVariable int familyId) {
        return readingActivityDao.getReadingTimeByFamilyId(familyId);
    }

    @RequestMapping(path = "/addActivity", method = RequestMethod.POST)
    public void addActivity (@RequestBody ReadingActivity newActivity) {
        readingActivityDao.addActivity(newActivity);
    }

    @RequestMapping(path = "/deleteActivity/{activityId}", method = RequestMethod.DELETE)
    public void deleteActivity (@PathVariable int activityId) {
        // NEEDS PARENT-ONLY PERMISSIONS
        readingActivityDao.deleteActivity(activityId);
    }

    @RequestMapping(path = "/updateActivity/{activityId}", method = RequestMethod.PUT)
    public void updateActivity (@RequestBody ReadingActivity updateActivity, @PathVariable int activityId) {
        readingActivityDao.updateActivity(updateActivity, activityId);
    }





}

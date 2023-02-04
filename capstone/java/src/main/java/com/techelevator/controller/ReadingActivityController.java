package com.techelevator.controller;

import com.techelevator.dao.ReadingActivityDao;
import com.techelevator.model.ReadingActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ReadingActivityController {

    @Autowired
    private ReadingActivityDao readingActivityDao;

    @RequestMapping(path = "/activities")
    List<ReadingActivity> getAllReadingActivities() {
        List<ReadingActivity> activityList = readingActivityDao.getAllReadingActivities();
        return activityList;
    }

    @RequestMapping(path = "/activities/timeRead/{user_id}")
    int getReadingTimeByUserId (int userId){
        return readingActivityDao.getReadingTimeByUserId(userId);
    }

    @RequestMapping(path = "/activities/timeRead/{family_id}")
    int getReadingTimeByFamilyId (int familyId) {
        return readingActivityDao.getReadingTimeByFamilyId(familyId);
    }

    @RequestMapping(path = "/addActivity", method = RequestMethod.POST)
    void addActivity (ReadingActivity newActivity) {
    }

    @RequestMapping(path = "/deleteActivity/{activityId}", method = RequestMethod.DELETE)
    void deleteActivity (int activityId) {
        // NEEDS PARENT-ONLY PERMISSIONS
        // Principal principal as second parameter
        readingActivityDao.deleteActivity(activityId);
    }

    @RequestMapping(path = "/updatePrize/{prizeId}", method = RequestMethod.PUT)
    void updateActivity (ReadingActivity updateActivity, int activityId) {
        readingActivityDao.updateActivity(updateActivity, activityId);
    }





}

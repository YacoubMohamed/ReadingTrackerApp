package com.techelevator.dao;

import com.techelevator.model.ReadingActivity;

import java.util.List;

public interface ReadingActivityDao {

    void addActivity ();
    void deleteActivity ();
    void updateActivity ();
    int getReadingTimeByUserId (int userId);
    int getReadingTimeByFamilyId (int familyId);
    // int getActivityByActivityId (int activityId);
    List <ReadingActivity> getAllReadingActivities ();

}

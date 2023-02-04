package com.techelevator.dao;

import com.techelevator.model.ReadingActivity;

import java.util.List;

public interface ReadingActivityDao {

    List <ReadingActivity> getAllReadingActivities ();
    int getReadingTimeByUserId (int userId);
    int getReadingTimeByFamilyId (int familyId);
    void addActivity ();
    void deleteActivity ();
    void updateActivity ();

}

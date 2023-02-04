package com.techelevator.dao;

import com.techelevator.model.ReadingActivity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcReadingActivityDao implements ReadingActivityDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcReadingActivityDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ReadingActivity> getAllReadingActivities() {
        List<ReadingActivity> activityList = new ArrayList<>();
        String sql = "SELECT * FROM reading_activity;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()) {
            activityList.add(mapRowToReadingActivities(rowSet));
        }
        return activityList;
    }

    @Override
    public int getReadingTimeByUserId(int userId) {
        return 0;
    }

    @Override
    public int getReadingTimeByFamilyId(int familyId) {
        return 0;
    }

    @Override
    public void addActivity() {

    }

    @Override
    public void deleteActivity() {

    }

    @Override
    public void updateActivity() {

    }

    private ReadingActivity mapRowToReadingActivities (SqlRowSet rowSet) {
        ReadingActivity readingActivity = new ReadingActivity();
        readingActivity.setActivityId(rowSet.getInt("activity_id"));
        readingActivity.setUserId(rowSet.getInt("user_id"));
        readingActivity.setFamilyId(rowSet.getInt("family_id"));
        readingActivity.setBookId(rowSet.getInt("book_id"));
        readingActivity.setBookFormat(rowSet.getString("book_format"));
        readingActivity.setNotes(rowSet.getString("notes"));
        return readingActivity;
    }
}

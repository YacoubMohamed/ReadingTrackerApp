package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReadingActivity {

    private int activityId;
    @JsonProperty ("user_id")
    private int userId;
    @JsonProperty ("family_id")
    private int familyId;
    @JsonProperty ("book_id")
    private int bookId;
    @JsonProperty ("time_read")
    private int timeRead;
    @JsonProperty ("book_format")
    private String bookFormat;
    @JsonProperty ("notes")
    private String notes;
    // private String dateStarted;
    // private String dateFinished;

    public ReadingActivity() {
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getTimeRead() {
        return timeRead;
    }

    public void setTimeRead(int timeRead) {
        this.timeRead = timeRead;
    }

    public String getBookFormat() {
        return bookFormat;
    }

    public void setBookFormat(String bookFormat) {
        this.bookFormat = bookFormat;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ReadingActivity(int activityId, int userId, int familyId, int bookId, int timeRead, String bookFormat, String notes) {
        this.activityId = activityId;
        this.userId = userId;
        this.familyId = familyId;
        this.bookId = bookId;
        this.timeRead = timeRead;
        this.bookFormat = bookFormat;
        this.notes = notes;
    }
}


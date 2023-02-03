package com.techelevator.model;

public class ReadingActivity {
    private int activityId;
    private int userId;
    private int familyId;
    private int bookId;
    private int timeRead;
    private String bookFormat;
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


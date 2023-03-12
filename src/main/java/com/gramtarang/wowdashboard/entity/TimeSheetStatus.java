package com.gramtarang.wowdashboard.entity;

public enum TimeSheetStatus {
    SUBMITTED(0),
    APPROVED(1),
    REJECTED(2);

    private int id;
    TimeSheetStatus(int id) {
        this.id = id;
    }

    public int getId() {return  id;}

    public void setId(int id) { this.id = id; }
}

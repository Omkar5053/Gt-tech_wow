package com.gramtarang.wowdashboard.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public enum ROLES {
    STUDENT(0),
    GUIDE(1),
    ADMIN(2);

    private int id;
    ROLES(int id) {
        this.id = id;
    }

    public int getId() {return  id;}

    public void setId(int id) { this.id = id; }
}

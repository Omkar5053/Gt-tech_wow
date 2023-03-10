package com.gramtarang.wowdashboard.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public enum ROLES {
    ADMIN(0),
    FACULTY(1),
    STUDENT(2),
    GUEST(3),
    DEAN(4),
    MGMT(5);

    private int id;
    ROLES(int id) {
        this.id = id;
    }

    public int getId() {return  id;}

    public void setId(int id) { this.id = id; }
}

package com.example.libraryplaces.dtos;

import jakarta.persistence.Column;

public class PlacesDTO {
    private long placeid;
    private String building;
    private String floor;
    private String room;
    private String seat;

    public PlacesDTO(long placeid, String building, String floor, String room, String seat)
    {
        this.placeid = placeid;
        this.building = building;
        this.floor = floor;
        this.room = room;
        this.seat = seat;
    }
    public long getPlaceid() {
        return placeid;
    }
    public void setPlaceid(long Placeid) {
        this.placeid = Placeid;
    }
    public String getBuilding() {
        return building;
    }
    public void setBuilding(String building) {
        this.building = building;
    }
    public String getFloor() {
        return floor;
    }
    public void setFloor(String floor) {
        this.floor = floor;
    }
    public String getRoom() {
        return room;
    }
    public void setRoom(String room) {
        this.room = room;
    }
    public String getSeat() {
        return seat;
    }
    public void setSeat(String seat) {
        this.seat = seat;
    }

}

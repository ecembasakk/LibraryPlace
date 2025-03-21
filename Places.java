package com.example.libraryplaces.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
//@NoArgsConstructor
@AllArgsConstructor
public class Places {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long placeid;
    @Column(length = 32)
    private String building;
    @Column(length = 32)
    private String floor;
    @Column (length=32)
    private String room;
    @Column(length = 32)
    private String seat;
    @OneToMany(mappedBy = "places", cascade = CascadeType.ALL)
    private List<Reservation> reservations;
    public Places() {
    }
    public Places(String building, String floor, String room, String seat) {
        this.building = building;
        this.floor = floor;
        this.room = room;
        this.seat = seat;
    }
    public Long getId() {return placeid;}
    public void setId(Long id) {this.placeid = id;}
    public String getBuilding() {return building;}
    public void setBuilding(String building) {this.building = building;}
    public String getFloor() {return floor;}
    public void setFloor(String floor) {this.floor = floor;}
    public String getRoom() {return room;}
    public void setRoom(String room) {this.room = room;}
    public String getSeat() {return seat;}
    public void setSeat(String seat) {this.seat = seat;}
    public List<Reservation> getReservations() {return reservations;}
    public void setReservations(List<Reservation> reservations) {this.reservations = reservations;}
}

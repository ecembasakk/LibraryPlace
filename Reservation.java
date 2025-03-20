package com.example.libraryplace1.model;

import com.example.libraryplace1.dtos.ReservationDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;
import java.time.LocalTime;
@Data

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="date")
    private LocalDateTime Date;

    @Column(name="duration")
    private LocalTime Duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "id",nullable = false)
    private Students students;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "placeid",nullable = false)
    private Places places;

    public ReservationDTO viewAsReservationDTO() {return new ReservationDTO(id,Date,Duration);}
    public Reservation() {}

    public Reservation(long id,LocalDateTime Date,LocalTime Duration,Students students,Places places) {
        this.id = id;
        this.Date = Date;
        this.Duration = Duration;
        this.students = students;
        this.places = places;
    }
    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public LocalDateTime getDate() {return Date;}

    public void setDate(LocalDateTime Date) {this.Date = Date;}

    public LocalTime getDuration() {return Duration;}

    public void setDuration(LocalTime Duration) {this.Duration = Duration;}

    public Students getStudents() {return students;}

    public void setStudents(Students students) {this.students = students;}

    public Places getPlaces() {return places;}

    public void setPlaces(Places places) {this.places = places;}

    @Override
    public String toString() {
        return "Reservation{"+ "id=" + id +
                ",Date=" + Date +
                ",Duration=" + Duration +
                ",student=" + students +
                ",place=" + places +
                '}';
    }

}

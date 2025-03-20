package com.example.libraryplace1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import java.util.List;
@Entity
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 16)
    private String name;
    @Column(length = 16)
    private String department;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    public Students() {
    }
    public Students(Long id,String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;

    }
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getDepartment() {return department;}
    public void setDepartment(String department) {this.department = department;}

    public List<Reservation> getReservations() {return reservations;}
    public void setReservations(List<Reservation> reservations) {this.reservations = reservations;}

}

package com.example.libraryplace1.dtos;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class ReservationDTO {
    private long reservationId;
    private LocalDateTime Date;
    private LocalTime Duration;
    private StudentsDTO studentsDTO;
    private PlacesDTO placesDTO;

    public ReservationDTO(long reservationId, LocalDateTime Date, LocalTime Duration) {
        this.reservationId = reservationId;
        this.Date = Date;
        this.Duration = Duration;

    }
    public ReservationDTO(long reservationId, LocalDateTime Date, LocalTime Duration, StudentsDTO studentsDTO,PlacesDTO placesDTO) {
        this.reservationId = reservationId;
        this.Date = Date;
        this.Duration = Duration;
        this.studentsDTO = studentsDTO;
        this.placesDTO = placesDTO;
    }

    public long getId() {return reservationId;}
    public void setId(long reservationId) {this.reservationId = reservationId;}
    public LocalDateTime getDate() {return Date;}
    public void setDate(LocalDateTime Date) {this.Date = Date;}
    public LocalTime getDuration() {return Duration;}
    public void setDuration(LocalTime Duration) {this.Duration = Duration;}
    public StudentsDTO getStudentsDTO() {return studentsDTO;}
    public void setStudentsDTO(StudentsDTO studentsDTO) {this.studentsDTO = studentsDTO;}
    public PlacesDTO getPlacesDTO() {return placesDTO;}
    public void setPlacesDTO(PlacesDTO placesDTO) {this.placesDTO = placesDTO;}
}

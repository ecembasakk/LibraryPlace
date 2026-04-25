package com.example.backend.Repository;

import com.example.backend.Models.Places;
import com.example.backend.Models.Reservation;
import com.example.backend.Models.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
//    @Query("SELECT r FROM Reservation r WHERE r.isDeleted = false AND r.students.id = :studentId")
//    List<Reservation> findActiveByStudentId(@Param("studentId") Long studentId);
//
//    // Get all active reservations (admin view)
//    @Query("SELECT r FROM Reservation r WHERE r.isDeleted = false")
//    List<Reservation> findAllActive();
}

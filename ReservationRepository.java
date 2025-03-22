package com.example.libraryplace1.repository;

import com.example.libraryplace1.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import java.util.List;
@Repository  
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByStudents_Id(Long studentId);
}

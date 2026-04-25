package com.example.backend.Repository;

import com.example.backend.Models.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Students, Long> {

//    @Query(value = "SELECT s FROM Students s WHERE s.isDeleted= FALSE")
//    List<Students> getUndeleted();

}

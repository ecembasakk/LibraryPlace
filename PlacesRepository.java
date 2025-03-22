package com.example.libraryplaces.repository;

import com.example.libraryplaces.model.Places;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Places, Long> {
}
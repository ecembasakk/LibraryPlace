package com.example.backend.Controllers;
import com.example.backend.Models.Places;
import com.example.backend.Models.Reservation;
import com.example.backend.Repository.PlacesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/place")
public class PlacesController {

    private final PlacesRepository placesRepository;
    public PlacesController(PlacesRepository placesRepository) {this.placesRepository = placesRepository;}

    @GetMapping("/all")
    public ResponseEntity<List<Places>> getAllPlaces(){
        List<Places> places= placesRepository.findAll();
        return new ResponseEntity<>(places, HttpStatus.OK);
    }
//
//    @GetMapping("/get/{id}")
//    public ResponseEntity<Places> getPlaceById(@PathVariable("id") Long placeid){
//        Optional<Places> places=placesRepository.findById(placeid);
//        if(places.isPresent()){
//            return new ResponseEntity<>(places.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

    @PostMapping(value = "/add")
    public ResponseEntity<Places> addPlace(@RequestBody Places places){
        return new ResponseEntity<>(placesRepository.save(places),HttpStatus.CREATED);
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<Places> updatePlaces(@PathVariable("id") Long placeid, @RequestBody Places places){
//        Optional<Places> placesOptional=placesRepository.findById(placeid);
//        if(placesOptional.isPresent()){
//            places.setId(placeid);
//            return new ResponseEntity<>(placesRepository.save(places),HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PostMapping("/delete/id")
//    public ResponseEntity<Places> deletePlace(@PathVariable("id") Long placeid){
//        Optional<Places> places= placesRepository.findById(placeid);
//        if(places.isPresent()){
//            placesRepository.delete(places.get());
//            return new ResponseEntity<>(places.get(), HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
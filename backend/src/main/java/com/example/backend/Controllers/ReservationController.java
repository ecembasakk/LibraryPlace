package com.example.backend.Controllers;

import com.example.backend.Models.Reservation;
import com.example.backend.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/reservation")
public class ReservationController
{
    @Autowired

    private ReservationRepository reservationRepository;


    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getAllReservations(){
        List<Reservation> reservations = reservationRepository.findAll();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }
//    @GetMapping("/get/{id}")
//    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") Long reservation_id){
//        Optional<Reservation> reservation=reservationRepository.findById(reservation_id);
//        if(reservation.isPresent()){
//            return new ResponseEntity<>(reservation.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

    @PostMapping("/add")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation){
        return new ResponseEntity<>(reservationRepository.save(reservation),HttpStatus.CREATED);
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Reservation> deleteReservation(@PathVariable("id") Long reservation_id){
//        Optional<Reservation> reservation=reservationRepository.findById(reservation_id);
//        if(reservation.isPresent()){
//            reservationRepository.delete(reservation.get());
//            return new ResponseEntity<>(reservation.get(),HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Reservation> updateReservation(@PathVariable("id") Long reservation_id, @RequestBody Reservation reservation){
//        Optional<Reservation> reservationOptional=reservationRepository.findById(reservation_id);
//        if(reservationOptional.isPresent()){
//            reservation.setId(reservation_id);
//            return new ResponseEntity<>(reservationRepository.save(reservation),HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    @GetMapping("/pdf")
    public ResponseEntity<Void> generateReservationPdf() throws FileNotFoundException, JRException {
        List<Reservation> reservations = reservationRepository.findAll();
        String path = "/Users/Leen Husseini/OneDrive/Desktop"; // kendi masaüstü yolunu yaz
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(reservations);
        File file = ResourceUtils.getFile("classpath:reservation2.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "/reservations_report.pdf");

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
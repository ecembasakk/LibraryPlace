package com.example.backend.Controllers;


import com.example.backend.Models.Students;
import com.example.backend.Repository.StudentsRepository;
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
@RequestMapping("/student")
public class StudentsController {

    @Autowired
    private StudentsRepository studentsRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Students>> getAllStudents() {
        List<Students> students = studentsRepository.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }




    @GetMapping("/get/{id}")
    public ResponseEntity<Students> getStudentById(@PathVariable("id") Long id) {
        Optional<Students> students=studentsRepository.findById(id);
        if(students.isPresent()){
            return new ResponseEntity<>(students.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/add")
    public ResponseEntity<Students> addStudent(@RequestBody Students student) {
        return new ResponseEntity<>(studentsRepository.save(student), HttpStatus.CREATED);
    }


//    @PutMapping("/update/{id}")
//    public ResponseEntity<Students> updateStudents(@PathVariable("id") Long id, @RequestBody Students students){
//        Optional<Students> studentsOptional=studentsRepository.findById(id);
//        if(studentsOptional.isPresent()){
//            students.setId(id);
//            return new ResponseEntity<>(studentsRepository.save(students),HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
// }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Students> deleteStudent(@PathVariable("id") Long id){
//        Optional<Students> Students = studentsRepository.findById(id);
//        if(Students.isPresent()) {
//            studentsRepository.delete(Students.get());
//            return new ResponseEntity<>(Students.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//
//
//    @GetMapping("/pdf")
//    public ResponseEntity<Void> generateStudentsPdf() throws FileNotFoundException, JRException {
//        List<Students> students= studentsRepository.findAll();
//        String Path = "/home/ecem/Desktop";
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(students);
//        File file = ResourceUtils.getFile("classpath:students.jrxml");
//        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null, dataSource);
//        JasperExportManager.exportReportToPdfFile(jasperPrint,Path+"/students_report.pdf");
//
//        return new ResponseEntity(HttpStatus.OK);
//    }


}

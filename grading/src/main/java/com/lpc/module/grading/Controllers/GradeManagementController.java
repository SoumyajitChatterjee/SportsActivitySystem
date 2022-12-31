package com.lpc.module.grading.Controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lpc.module.grading.Models.Grade;

@RestController
public class GradeManagementController {
    @PostMapping("/grades")
    public String createGrade(@RequestBody Grade grade) {
        return  grade.getGrade();
    }
    @GetMapping("/grades/{id}")
    public String retreiveGrade(@PathVariable(name="id") int gradeId) {
        return new String("Grade Successfully Entered");
    }
    @DeleteMapping("/grades/{id}")
    public String deleteGrade(@PathVariable(name="id") int gradeId) {
        return new String("Grade Successfully Deleted");
    }
    @PutMapping("/grades/{id}")
    public String createGrade(@PathVariable(name="id") int gradeId, @RequestBody Grade grade) {
        return new String("Grade Successfully Updated");
    }

}

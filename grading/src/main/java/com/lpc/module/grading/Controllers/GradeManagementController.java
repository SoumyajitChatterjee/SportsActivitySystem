package com.lpc.module.grading.Controllers;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lpc.module.grading.Models.Grade;
import com.lpc.module.grading.Services.GradeManagementService;

@RestController
public class GradeManagementController {
    
    @Autowired
    private GradeManagementService gms;

    @PostMapping("/grades")
    public @ResponseBody Optional<Grade> createGrade(@RequestBody Grade grade) {
        return gms.createGrade(grade);
    }

    @GetMapping("/grades/{id}")
    public @ResponseBody Optional<Grade> retreiveGrade(@PathVariable(name="id") int gradeId) {
        return gms.retreiveGrade(gradeId);
    }
    @GetMapping("/grades")
    public @ResponseBody Iterable<Grade> retreiveAllGrade() {
        return gms.retreiveAllGrade();
    }

    @DeleteMapping("/grades/{id}")
    public @ResponseBody Optional<Grade> deleteGrade(@PathVariable(name="id") int gradeId) {
        return gms.deleteGrade(gradeId);
    }

    @PutMapping("/grades/{id}")
    public @ResponseBody Optional<Grade> updateGrade(@PathVariable(name="id") int justId, @RequestBody Grade grade) {
        return gms.updateGrade(justId, grade);
    }

    @PatchMapping("/grades/{id}")
    public @ResponseBody Optional<Grade> partiallyUpdateGrade(@PathVariable(name="id") int gradeId, @RequestBody String grade) {
        return gms.partiallyUpdateGrade(gradeId, grade);
    }

}

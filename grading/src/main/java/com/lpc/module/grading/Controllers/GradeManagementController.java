package com.lpc.module.grading.Controllers;

import java.util.Optional;
import org.springframework.beans.BeanUtils;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lpc.module.grading.Models.Grade;
import com.lpc.module.grading.Models.UserRepository;

@RestController
public class GradeManagementController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/grades")
    public String createGrade(@RequestBody Grade grade) {
        userRepository.save(grade);
        return  grade.getGrade();
    }
    @GetMapping("/grades/{id}")
    public @ResponseBody Optional<Grade> retreiveGrade(@PathVariable(name="id") int gradeId) {
        return userRepository.findById(gradeId);
        // return new String("Grade Successfully Entered");
    }
    @GetMapping("/grades")
    public @ResponseBody Iterable<Grade> retreiveAllGrade() {
        return userRepository.findAll();
        // return new String("Grade Successfully Entered");
    }
    @DeleteMapping("/grades/{id}")
    public String deleteGrade(@PathVariable(name="id") int gradeId) {
        userRepository.deleteById(gradeId);
        return new String("Grade Successfully Deleted");
    }

    @PutMapping("/grades/{id}")
    public @ResponseBody Optional<Grade> createGrade(@PathVariable(name="id") int justId, @RequestBody Grade grade) {
        Grade retGrade = userRepository.findById(justId).get();
        BeanUtils.copyProperties(grade, retGrade);
        retGrade.setId(justId);
        userRepository.save(retGrade);
        return userRepository.findById(justId);
    }

    @PatchMapping("/grades/{id}")
    public @ResponseBody Optional<Grade> createGrade(@PathVariable(name="id") int gradeId, @RequestBody String grade) {
        Grade retGrade = userRepository.findById(gradeId).get();
        retGrade.setGrade(grade);
        userRepository.save(retGrade);
        return userRepository.findById(gradeId);
    }

}

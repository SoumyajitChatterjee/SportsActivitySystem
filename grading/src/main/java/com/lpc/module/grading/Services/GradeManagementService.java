package com.lpc.module.grading.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Optional;
import org.springframework.beans.BeanUtils;

import com.lpc.module.grading.Models.UserRepository;
import com.lpc.module.grading.Models.Grade;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Service
public class GradeManagementService{
    @Autowired
    private UserRepository userRepository;

    public @ResponseBody Optional<Grade>  createGrade(Grade grade) {
        userRepository.save(grade);
        return userRepository.findById(grade.getId());
    }

    public @ResponseBody Optional<Grade> retreiveGrade(int gradeId) {
        return userRepository.findById(gradeId);
    }

    public @ResponseBody Iterable<Grade> retreiveAllGrade() {
        return userRepository.findAll();
    }

    public @ResponseBody Optional<Grade> deleteGrade(int gradeId) {
        userRepository.deleteById(gradeId);
        return userRepository.findById(gradeId);
    }

    public @ResponseBody Optional<Grade> updateGrade(int justId, Grade grade) {
        Grade retGrade = userRepository.findById(justId).get();
        BeanUtils.copyProperties(grade, retGrade);
        retGrade.setId(justId);
        userRepository.save(retGrade);
        return userRepository.findById(justId);
    }

    public @ResponseBody Optional<Grade> partiallyUpdateGrade(int gradeId, String grade) {
        Grade retGrade = userRepository.findById(gradeId).get();
        retGrade.setGrade(grade);
        userRepository.save(retGrade);
        return userRepository.findById(gradeId);
    }


}
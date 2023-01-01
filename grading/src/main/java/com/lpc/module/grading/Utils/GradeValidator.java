package com.lpc.module.grading.Utils;

import com.lpc.module.grading.Models.Grade;


public class GradeValidator {
    String[] grades = {"A", "B", "C", "D", "E", "F"};
    public boolean checkIfGradeValid(String grade){
        for(String letterGrade: grades){
            if(letterGrade.equals(grade)){
                return true;
            }
        }
        return false;
    }

}

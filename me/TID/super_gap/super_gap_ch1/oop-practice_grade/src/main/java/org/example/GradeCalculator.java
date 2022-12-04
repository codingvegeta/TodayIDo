package org.example;

import java.util.List;

public class GradeCalculator {
    private final Courses courses;


    public GradeCalculator(List<Course> courses) {
        this.courses =new Courses(courses);
    }

    public double calculateGrade() {
        double totalMultipliedCreditCourseGrade = courses.multiplyCreditAndCourseGrade();

        // 수강신청 총학점 수
        int totalCompletedCredit = courses.calculateTotalCompletedCredit();


        return totalMultipliedCreditCourseGrade / totalCompletedCredit;

    }
}

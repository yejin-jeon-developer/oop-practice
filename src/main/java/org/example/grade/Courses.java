package org.example.grade;

import java.util.List;

public class Courses { // 일급 컬렉션 : 여러개의 정보만 가진 클래스 (Set, 등...)
    private final List<Course> courses;
    // 다른 변수가 있으면 안됨.
    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
        return courses.stream()
                .mapToDouble(Course::multiplyCreditAndCourseGrade)
                .sum();
    }

    public int calculateCompletedCredit() {
        int totalCompletedCredit =  courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
        return totalCompletedCredit;
    }
}

package org.example.grade;

import org.example.grade.Course;
import org.example.grade.GradeCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
 * MVC패턴(Model-View-Controller) 기반으로 구현한다.
 * 일급 컬렉션 사용
 */
public class GradeCalculatorTest {
    // 학점 계산기 도메인 : 이수한 과목, 학점 계산 -> 생각 나는데까지 도출
    // 객체지향 프로그래밍, 자료구조, 중국어 회화... --> 과목 (코스) 라는 클래스로 표현 --> 동적인 객체를 정적인 타입으로 추상화

    // 이수한 과목을 전달하여 평균학점 계산 요청 ---> 학점 계산 ---->    (학점수×교과목 평점)의 합계  ---> 과목(코스)
    //                                             --->     수강신청 총학점 수        ----> 과목(코스)

    @DisplayName("평균 학점을 계산한다.")
    @Test
    void calculateGradeTest() {
        List<Course> courses = List.of(new Course("OOP", 3, "A+"),
                new Course("자료구조", 3, "A+"));

        GradeCalculator gradeCalcuator = new GradeCalculator(courses);
        double gradeResult = gradeCalcuator.calculateGrade();

        assertThat(gradeResult).isEqualTo(4.5);
    }
}

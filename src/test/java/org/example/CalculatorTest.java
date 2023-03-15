package org.example;

import org.example.calculate.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * • 간단한 사칙연산을 할 수 있다.
 * • 양수로만 계산할 수 있다.
 * • 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.
 * • MVC패턴(Model-View-Controller) 기반으로 구현한다.
 */
public class CalculatorTest {
    // 1 + 2 -----> Calculator
    //  3    <----- Calculator
    @DisplayName("덧셈 연산을 수행한다.")
    @ParameterizedTest
    @MethodSource("fomulaAndResult")
    void calculateTest(PositiveNumber operand1, String operator, PositiveNumber operand2, PositiveNumber result) {
        int calculateResult = Calculator.calcuate(operand1, operator, operand2);
        assertThat(calculateResult).isEqualTo(result);
    }

    private static Stream<Arguments> fomulaAndResult() {
        return Stream.of(
                arguments(1, "+", 2, 3),
                arguments(1, "-", 2, -1),
                arguments(4, "*", 2, 8),
                arguments(4, "/", 2, 2)
        );
    }
    @DisplayName("나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.") // PositiveNumber 에서 0 Validation 체크를 해주므로 필요없어지는 테스트 코드, PositiveNumberTest 로 create 테스트 진행하는게 좋음
    @Test
    void calcuateExceptionTest() {
        assertThatCode(() -> Calculator.calcuate(new PositiveNumber(10), "/", new PositiveNumber(0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }

//    @DisplayName("덧셈 연산을 수행한다.")
//    @Test
//    void additionTest() {
//        int result = Calculator.calcuate(1, "+", 2);
//        assertThat(result).isEqualTo(3);
//    }
//
//    @DisplayName("뺄셈 연산을 수행한다.")
//    @Test
//    void subtractTest() {
//        int result = Calculator.calcuate(1, "-", 2);
//        assertThat(result).isEqualTo(-1);
//    }
}

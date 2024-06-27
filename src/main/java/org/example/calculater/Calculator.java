package org.example.calculater;

import org.example.calculater.operator.*;

import java.util.List;

public class Calculator {
//    1. interface를 구현한 4개의 구현체를 받음
    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(
            new AdditionOperator(),
            new SubtractionOperator(),
            new MultiplicationOperator(),
            new DivisionOperator()
    );

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
//        --- 기존 방식
//        if("+".equals(operator)) {
//            return operand1 + operand2;
//        } else if("-".equals(operator)) {
//            return operand1 - operand2;
//        } else if("*".equals(operator)) {
//            return operand1 * operand2;
//        } else if("/".equals(operator)) {
//            return operand1 / operand2;
//        }

//        --- enum 사용
//        return ArithmeticOperator.calculate(operand1, operator, operand2);

//        --- interface 사용
        return arithmeticOperators.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(operator)) // 2. 들어온 operator에 맞는 구현체 찾음
                .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))// 3. 찾은 구현체에게 calculate 작업을 위임
                .findFirst() // 4-1. 값이 있다면 첫번째 값 가져오기
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다.")); // 4-2. 값이 없으면 예외 발생
    }
}

package org.example.calculater;

/**
 * 양수만 연산 가능한 요구사항을 처리하기 위한 V.O
 * 만약 이게 없으면, operand1, operand2를 매개변수로 받는 모든 메서드에서 validation을 해야함
 */

public class PositiveNumber {
    private final int value;

    public PositiveNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if(isNegativeNumber(value)) {
            throw new IllegalArgumentException("0 또는 음수를 전달할 수 없습니다.");
        }
    }

    private boolean isNegativeNumber(int value) {
        return value <= 0;
    }

    public int toInt() {
        return value;
    }
}

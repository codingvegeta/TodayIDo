package org.example.calcultator.tobe;

import org.example.calcultator.domain.PositiveNumber;

public interface NewArithmeticOperator {


    boolean supports(String operator);

    int calculate(PositiveNumber operand1, PositiveNumber operand2);
}

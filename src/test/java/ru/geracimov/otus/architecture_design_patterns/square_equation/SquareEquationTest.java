package ru.geracimov.otus.architecture_design_patterns.square_equation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SquareEquationTest {

    private SquareEquation squareEquation;

    @BeforeEach
    void setUp() {
        squareEquation = new SquareEquation();
    }

    @Test
    void squareEquationRunTest() {
        Assertions.assertNotNull(squareEquation.solve(1.0, 2.0, 3.0));
    }

}

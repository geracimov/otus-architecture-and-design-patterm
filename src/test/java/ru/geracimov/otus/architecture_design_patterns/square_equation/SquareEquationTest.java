package ru.geracimov.otus.architecture_design_patterns.square_equation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareEquationTest {

    private SquareEquation squareEquation;

    @BeforeEach
    void setUp() {
        squareEquation = new SquareEquation();
    }

    @Test
    void squareEquationRunTest() {
        assertNotNull(squareEquation.solve(1.0, 2.0, 3.0));
    }

    @Test
    @DisplayName("тест, который проверяет, что для уравнения x^2+1 = 0 корней нет (возвращается пустой массив)")
    void squareEquationHasNoRootsTest() {
        assertArrayEquals(new double[]{}, squareEquation.solve(1.0, 0.0, 1.0));
    }

    @Test
    @DisplayName("тест, который проверяет, что для уравнения x^2-1 = 0 есть два корня кратности 1 (x1=1, x2=-1)")
    void quadraticEquationHasTwoRootsOfMultiplicity1Test() {
        assertArrayEquals(new double[]{1.0, -1.0}, squareEquation.solve(1.0, 0.0, -1.0));
    }

}

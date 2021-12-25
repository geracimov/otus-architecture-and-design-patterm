package ru.geracimov.otus.architecture_design_patterns.square_equation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class SquareEquationTest {

    private SquareEquation squareEquation;

    @BeforeEach
    void setUp() {
        ArgumentValidator validator = new ArgumentValidatorImpl();
        squareEquation = new SquareEquation(validator);
    }

    @Test
    void squareEquationRunTest() {
        assertNotNull(squareEquation.solve(1.0, 2.0, 3.0));
    }

    @Test
    @DisplayName("тест, который проверяет, что для уравнения x^2+1 = 0 корней нет (возвращается пустой массив)")
    void squareEquationHasNoRootsTest() {
        double[] roots = squareEquation.solve(1.0, 0.0, 1.0);
        assertArrayEquals(new double[]{}, roots);
    }

    @Test
    @DisplayName("тест, который проверяет, что для уравнения x^2-1 = 0 есть два корня кратности 1 (x1=1, x2=-1)")
    void quadraticEquationHasTwoRootsOfMultiplicity1Test() {
        double[] roots = squareEquation.solve(1.0, 0.0, -1.0);
        assertArrayEquals(new double[]{1.0, -1.0}, roots);
    }

    @Test
    @DisplayName("тест, который проверяет, что для уравнения x^2+2x+1 = 0 есть один корень кратности 2 (x1= x2 = -1)")
    void quadraticEquationHasOneRootsOfMultiplicity2Test() {
        double[] roots = squareEquation.solve(1.0, 2.0, 1.0);
        assertArrayEquals(new double[]{-1.0, -1.0}, roots);
    }

    @Test
    @DisplayName("тест, который проверяет, что для уравнения x^2+2x+1 = 0 есть один корень кратности 2 (x1= x2 = -1) с заданным eps")
    void quadraticEquationHasOneRootsOfMultiplicity2TestWithEps() {
        var validator = new ArgumentValidatorImpl(1e-10);
        squareEquation = new SquareEquation(validator);
        double[] roots = squareEquation.solve(1.0, 2.0, 1.0);
        assertArrayEquals(new double[]{-1.0, -1.0}, roots);
    }

    @Test
    @DisplayName("тест, который проверяет, что коэффициент a не может быть равен 0")
    void coefficientCannotBe0Test() {
        Executable solveWithAis0 = () -> squareEquation.solve(0.0, 2.0, 1.0);
        assertThrows(IllegalArgumentException.class, solveWithAis0);
    }

    @Test
    @DisplayName("тест, который проверяет, что коэффициенты не могут быть NaN")
    void coefficientCannotBeNanTest() {
        Executable solveWithAisNan = () -> squareEquation.solve(Double.NaN, Double.NaN, Double.NaN);
        assertThrows(IllegalArgumentException.class, solveWithAisNan);
    }

    @Test
    @DisplayName("тест, который проверяет, что коэффициенты не могут быть NEGATIVE_INFINITY")
    void coefficientCannotBeNegInfTest() {
        Executable solveWithAisNegInf = () -> squareEquation.solve(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        assertThrows(IllegalArgumentException.class, solveWithAisNegInf);
    }

    @Test
    @DisplayName("тест, который проверяет, что коэффициенты не могут быть POSITIVE_INFINITY")
    void coefficientCannotBePosInfTest() {
        Executable solveWithAisPosInf = () -> squareEquation.solve(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        assertThrows(IllegalArgumentException.class, solveWithAisPosInf);
    }

}

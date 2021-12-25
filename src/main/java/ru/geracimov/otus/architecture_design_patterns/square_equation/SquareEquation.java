package ru.geracimov.otus.architecture_design_patterns.square_equation;

public class SquareEquation {
    private final ArgumentValidator validator;

    public SquareEquation(ArgumentValidator validator) {
        this.validator = validator;
    }

    public double[] solve(double a, double b, double c) {
        validator.validate(a, b, c);
        double d = b * b - 4 * a * c;
        if (validator.compare(d, 0.0) >= 0) {
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (-b - Math.sqrt(d)) / (2 * a);
            return new double[]{x1, x2};
        }
        return new double[0];
    }

}

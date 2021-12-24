package ru.geracimov.otus.architecture_design_patterns.square_equation;

public class SquareEquation {
    private static final double DEFAULT_EPS = 1e-4;
    private final double eps;

    public SquareEquation() {
        this(DEFAULT_EPS);
    }

    public SquareEquation(double eps) {
        this.eps = eps;
    }

    public double[] solve(double a, double b, double c) {
        if (compare(a, 0.0) == 0) {
            throw new IllegalArgumentException("coefficient a cannot be 0");
        }
        double d = b * b - 4 * a * c;
        if (compare(d, 0.0) >= 0) {
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (-b - Math.sqrt(d)) / (2 * a);
            return new double[]{x1, x2};
        }
        return new double[0];
    }

    private int compare(double d1, double d2) {
        if (Math.abs(Math.abs(d1) - Math.abs(d2)) < eps) {
            return 0;
        }

        return d1 > d2 ? 1 : -1;
    }
}

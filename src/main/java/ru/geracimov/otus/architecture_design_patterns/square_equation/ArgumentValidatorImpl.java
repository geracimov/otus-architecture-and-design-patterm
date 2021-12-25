package ru.geracimov.otus.architecture_design_patterns.square_equation;

public class ArgumentValidatorImpl implements ArgumentValidator {
    private static final double DEFAULT_EPS = 1e-5;
    private final double eps;

    public ArgumentValidatorImpl() {
        this(DEFAULT_EPS);
    }

    public ArgumentValidatorImpl(double eps) {
        this.eps = eps;
    }

    @Override
    public void validate(double a, double b, double c) {
        if (compare(a, 0.0) == 0) {
            throw new IllegalArgumentException("coefficient a cannot be 0");
        }
        validate(a);
        validate(b);
        validate(c);
    }

    @Override
    public void validate(double arg) {
        if (Double.isNaN(arg) || Double.isInfinite(arg)) {
            throw new IllegalArgumentException(String.format("argument is illegal: %f", arg));
        }
    }

    @Override
    public int compare(double d1, double d2) {
        if (Math.abs(Math.abs(d1) - Math.abs(d2)) < eps) {
            return 0;
        }

        return d1 > d2 ? 1 : -1;
    }
}

package ru.geracimov.otus.architecture_design_patterns.square_equation;

public interface ArgumentValidator {

    void validate(double a, double b, double c);

    void validate(double arg);

    int compare(double d1, double d2);

}

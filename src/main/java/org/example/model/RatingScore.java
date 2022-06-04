package org.example.model;

public class RatingScore {

    public static final double MAX = 100.0d;
    public static final double MIN = 0.0d;

    private final double value;

    public RatingScore(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}

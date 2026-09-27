package by.itstep.lesson5;

import java.math.BigDecimal;

enum Position {
    DIRECTOR(new BigDecimal(1)),
    WORKER(new BigDecimal(2));

    private static final String DIRECTOR_NAME = "director";
    private static final String WORKER_NAME = "worker";

    public final BigDecimal coefficient;

    Position(BigDecimal coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public String toString() {
        return this.equals(DIRECTOR)? DIRECTOR_NAME : WORKER_NAME;
    }
}

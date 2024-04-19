package gri.riverjach.kata.fibonacci;

import java.math.BigInteger;

public class Fibonacci {

    private Fibonacci() {
        throw new IllegalStateException("Utility class");
    }

    public static BigInteger fibonacciSuite(int number) {
        if (number > 1) {
            return new BigInteger("2");
        }
        return new BigInteger("1");
    }
}

package gri.riverjach.kata.fibonacci;

import java.math.BigInteger;

public class Fibonacci {

    private Fibonacci() {
        throw new IllegalStateException("Utility class");
    }

    public static BigInteger fibonacciSuite(int number) {
        return fibonacciSuite(BigInteger.ONE, BigInteger.ONE, number);
    }

    private static BigInteger fibonacciSuite(BigInteger sumFib2, BigInteger sumFib1, int number) {
        if (number > 1) {
            return fibonacciSuite(sumFib1, sumFib1.add(sumFib2), number - 1);
        }
        return sumFib1;
    }
}

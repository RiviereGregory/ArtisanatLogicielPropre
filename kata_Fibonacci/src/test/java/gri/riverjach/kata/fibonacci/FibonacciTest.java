package gri.riverjach.kata.fibonacci;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {
    @Test
    void when0ThenResult1() {
        assertEquals(BigInteger.ONE, Fibonacci.fibonacciSuite(0));
    }

    @Test
    void when1ThenResult1() {
        assertEquals(BigInteger.ONE, Fibonacci.fibonacciSuite(1));
    }

    @Test
    void when2ThenResult2() {
        assertEquals(BigInteger.valueOf(2), Fibonacci.fibonacciSuite(2));
    }

    @Test
    void when3ThenResult3() {
        assertEquals(BigInteger.valueOf(3), Fibonacci.fibonacciSuite(3));
    }

}

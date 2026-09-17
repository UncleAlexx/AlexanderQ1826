package by.itstep.lesson3;

import java.math.BigInteger;
import java.util.Arrays;

public class FirstProblem{

    public void FillWithFibonacci(BigInteger[] numbers){
        if(numbers == null || numbers.length == 0)
            return;
        numbers[0] = BigInteger.ZERO;
        if (numbers.length == 1)
            return;
        numbers[1] = BigInteger.ONE;

        for (int i = 2; i < numbers.length; i++) {
            numbers[i] = numbers[i - 1].add(numbers[i - 2]);
        }
    }
}

package by.itstep.lesson3;

import java.math.BigInteger;
import java.util.Arrays;

public class Program {

    public static void main() {
       var  numbers = new BigInteger[30];
       new FirstProblem().FillWithFibonacci(numbers);
       System.out.println(Arrays.toString(numbers));

       System.out.println( new SecondProblem().sumMinMax(new int[]{1,2,4,-1}));

       System.out.println(new ThirdProblem().getSumDifferenceOfElemsWithEvenOddIndexes(new int[]{0,-10}));
    }
}

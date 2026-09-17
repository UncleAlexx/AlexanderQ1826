package by.itstep.lesson3;

public class SecondProblem {
    public int sumMinMax(int[] numbers){
        if(numbers == null || numbers.length == 0)
            return 0;
        int min =  numbers[0], max = min;

        for (int i = 1; i < numbers.length; i++) {
            if(numbers[i] < min){
                min = numbers[i];
                continue;
            }
            if(numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max + min;
    }
}

package by.itstep.lesson3;

public class ThirdProblem {
    public int getSumOfOddEven (int [] numbers){
        if(numbers == null || numbers.length == 0)
            return 0;
        int sum = numbers[0];
        for (int i = 1; i < numbers.length; i++) {

            if((i & 1) == 1)
                sum -= numbers[i];
            else
                sum += numbers[i];
        }
        return  Math.abs(sum);
    }
}

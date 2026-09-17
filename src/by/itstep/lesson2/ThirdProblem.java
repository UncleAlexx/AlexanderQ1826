package by.itstep.lesson2;

public class ThirdProblem {

    public  int SumOfThreeMultiplesBetween(int a, int b){

        int max = a > b? a : b;
        int firstThreeMultiple = a == max? b : a;

        for (int i = firstThreeMultiple; i <= firstThreeMultiple + 2; i++){
            if(i % 3 == 0){
                firstThreeMultiple = i;
                break;
            }
        }
        var sum = 0;

        for(; firstThreeMultiple <= max; firstThreeMultiple += 3){
            sum += firstThreeMultiple;
        }
        return  sum;
    }
}

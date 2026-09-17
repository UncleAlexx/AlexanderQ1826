package by.itstep.lesson2;

import static java.lang.System.out;

public class FifthProblem {

    public void PrintSquare(char character, int length){
        if(length < 3)
            return;

        final int first = 1;
        int j;

        for (int i = 1; i <= length; i++) {
            if(i != first &&  i != length){
                out.print(character);
                for (j = 2;j < length; j++) {
                    out.print(' ');
                }
                out.print(character);
            }
            else{
                for (j = 1;j <= length; j++){
                    System.out.print(character);
                }
            }
            out.println();
        }
    }
}

package by.itstep.lesson2;

import java.util.Scanner;

import static java.lang.System.out;

public class ForthProblem {

    public  void PrintWhileExit(Scanner scanner){
        out.println("Введите слово1");
        String input = scanner.next();
        out.println(input);
        while (!input.equals("exit")){
            out.println("Введите слово2");
            input = scanner.next();
            out.println(input);
        }
    }
}

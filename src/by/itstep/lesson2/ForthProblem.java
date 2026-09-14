package by.itstep.lesson2;

import java.util.Scanner;

import static java.lang.System.out;

public class ForthProblem {

    public  void PrintWhileExit(Scanner scanner){
        out.println("Введите слово");
        String input = scanner.nextLine();
        out.println(input);
        while (!input.equals("exit")){
            out.println("Введите слово");
            input = scanner.nextLine();
            out.println(input);
        }
    }
}

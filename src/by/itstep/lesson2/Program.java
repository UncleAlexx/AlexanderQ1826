package by.itstep.lesson2;

import static java.lang.System.out;

import java.util.Scanner;

public class Program {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        FirstProblem firstProblem = new FirstProblem();
        out.println("Введите букву");
        out.println(firstProblem.GetIsVowelMessageWithIf(scanner.next().charAt(0)));
        out.println("Введите букву");
        out.println(firstProblem.GetIsVowelMessageWithSwitch(scanner.next().charAt(0)));
        out.println("Введите месяц");

        SecondProblem secondProblem = new SecondProblem();
        String month = scanner.next();
        out.println(secondProblem.getSeasonByMonth(month));

        out.println("Введите первое число:");
        int first = scanner.nextInt();
        out.println("Введите второе число:");
        int second = scanner.nextInt();
        out.println("Сумма чисел кратных 3 = " + new ThirdProblem().SumOfThreeMultiplesBetween(first, second));

        new ForthProblem().PrintWhileExit(scanner);

        new FifthProblem().PrintSquare('*',5);
        scanner.close();
    }
}

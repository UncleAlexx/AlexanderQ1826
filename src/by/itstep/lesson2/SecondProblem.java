package by.itstep.lesson2;

import java.util.Scanner;

public class SecondProblem {

    public  String getSeasonByMonth(String month) {
        if (month == null) {
            return "Неизвестный месяц: " + month;
        }
        System.out.print("Введите название месяца: ");
        switch (month) {
            case "декабрь":
            case "январь":
            case "февраль":
                return "Зима";

            case "март":
            case "апрель":
            case "май":
                return "Весна";

            case "июнь":
            case "июль":
            case "август":
                return "Лето";

            case "сентябрь":
            case "октябрь":
            case "ноябрь":
                return "Осень";

            default:
                return "Неизвестный месяц: ";
        }
    }
}

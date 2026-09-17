package by.itstep.lesson2;

public class SecondProblem {

    public  String getSeasonByMonth(String month) {
        switch (month == null? "" : month.toLowerCase()) {
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

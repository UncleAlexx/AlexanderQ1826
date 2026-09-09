package by.itstep.lesson1;
import static java.lang.IO.*;

public class Program {
    public static void main(String[] args) {
        byte grade = 41;
        if(grade >= 0 && grade <= 39){
            print("Неудовлетворительно (F) - Учи материал!");
        }else if(grade >= 40 && grade <= 59){
            print("Плохо (D) - Нужно подтянуть");
        }else if(grade >= 60 && grade <= 74){
            print("Удовлетворительно (C) - Можно лучше");
        }else if(grade >= 75 && grade <= 89){
            print("Хорошо (B) - Молодец!");
        }else if(grade >= 90 && grade <= 100){
            print("Отлично (A) - Ты гений!");
        }else{
            print("Ошибка! Введите число от 0 до 100");
        }
    }
}

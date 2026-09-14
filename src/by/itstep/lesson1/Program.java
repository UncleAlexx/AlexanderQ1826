package by.itstep.lesson1;

import static java.lang.System.out;

public class Program {
    public static void main(String[] args) {

        byte grade = 41;

        if(grade >= 0 && grade <= 39){
            out.print("Неудовлетворительно (F) - Учи материал!");
        }else if(grade >= 40 && grade <= 59){
            out.print("Плохо (D) - Нужно подтянуть");
        }else if(grade >= 60 && grade <= 74){
            out.print("Удовлетворительно (C) - Можно лучше");
        }else if(grade >= 75 && grade <= 89){
            out.print("Хорошо (B) - Молодец!");
        }else if(grade >= 90 && grade <= 100){
            out.print("Отлично (A) - Ты гений!");
        }else{
            out.print("Ошибка! Введите число от 0 до 100");
        }
    }
}


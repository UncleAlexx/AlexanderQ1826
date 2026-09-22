package by.itstep.lesson4;

import by.itstep.lesson4.FifthProblem.DeprecatedMethod;
import by.itstep.lesson4.FirstProblem.Month;
import by.itstep.lesson4.FirstProblem.MonthExtensions;
import by.itstep.lesson4.FirstProblem.Season;
import by.itstep.lesson4.ForthProblem.CtorsExample;
import by.itstep.lesson4.SecondProblem.ArrayExtensions;
import by.itstep.lesson4.SeventhProblem.Method;
import by.itstep.lesson4.SixthProblem.Overloading;
import by.itstep.lesson4.ThirdProblem.Sex;
import by.itstep.lesson4.ThirdProblem.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

    static void main(String[] args){
         List<String> testCollection = (Arrays.stream(Month.values()).map(Enum::name).collect(Collectors.toList()));
         testCollection.add(null);
         testCollection.add("");
         testCollection.stream().map(x-> {
             String seasonRaw = MonthExtensions.getSeasonByMonth(x);
             return seasonRaw == null  ? "Месяца"+seasonRaw +" не существует":
                    "Сезон месяца " + x.toLowerCase() +  " "+Season.valueOf(seasonRaw).toString().toLowerCase();
         }).forEach(System.out::println);

         ArrayExtensions arrayExtensions = new ArrayExtensions(true);
         int[] numbers = new int[332];
         for(int i = 0;i<numbers.length;i++){
             numbers[i] = i;
         }
         for(int i = -1 ;i <= 335;i++){
             System.out.println(arrayExtensions.getIndexByElem(numbers, i));
         }
         arrayExtensions.sort(numbers);
         System.out.println(Arrays.toString(numbers));
         System.out.println(arrayExtensions.max(numbers));

         User user = new User("name", "surname", Sex.MALE, 13, "Belarus", "Vitebsk");
         System.out.println(user.get_Age());
         user.increaseAgeBy(3);
         System.out.println(user.get_Age());
         System.out.println(user.getFullName());
         System.out.println(user.toString());
         user.setAddress("France", "Lyon");
         System.out.println(user);

         CtorsExample ctorsExample = new CtorsExample("value", "value2");

         DeprecatedMethod method1 = new DeprecatedMethod();
         System.out.println(method1.toString());

        Overloading overloading = new Overloading();
        overloading.method1(3);
        overloading.method1("");
        overloading.method1("diff", 3);

        Method method = new Method();
        method.method();

    }

}


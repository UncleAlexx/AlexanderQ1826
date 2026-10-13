package by.itstep.lesson8.Extensions;

public abstract class IntExtensions{

    public static int positiveOrDefault(int number, int byDefault){
        return  number > 0? number : byDefault;
    }
}

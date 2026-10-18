package by.itstep.lesson10.common;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class ChildHelpers {

    public static List<Child> filter(List<Child> children, Predicate<Child> predicate){
        return children.stream().filter(predicate).toList();
    }

    public static <T> List<T> toMap(List<Parent> children, Function<Parent, T> one){
        return  children.stream().map(one).toList();
    }
}

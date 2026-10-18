package by.itstep.lesson10.common;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class ParentsHelpers {

    public static List<Parent> filter(List<Parent> parents, Predicate<Parent> predicate){
        return parents.stream().filter(predicate).toList();
    }

    public static Integer childrenCount(List<Parent> parents){
        return parents.stream().reduce(0, (x,y) -> y.getChildren().size() + x, Integer::sum);
    }

    public static <T,T2> Map<T, T2> toMap(List<Parent> parents, Function<Parent, T> one, Function<Parent, T2> two){
        return  parents.stream().collect(Collectors.toMap(one, two));
    }
}

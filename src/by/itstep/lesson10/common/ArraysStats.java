package by.itstep.lesson10.common;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArraysStats<T extends Number & Comparable<T>> {
    public T[] buffer;

    public ArraysStats(T[] array) {
        buffer = array;
    }

    public MinMax<Optional<T>, T> minMax() {
        return Arrays.stream(buffer).collect(Collectors.teeing(
                Collectors.minBy(Comparator.<T>naturalOrder()),
                Collectors.maxBy(Comparator.<T>naturalOrder()),
                MinMax::new));
    }

    public Stream<T> filter(Predicate<T> predicate) {
        return Arrays.stream(buffer).filter(predicate);
    }

    public Stream<T> skip(int elementsToSkip){
        return Arrays.stream(buffer).skip(elementsToSkip);
    }
}

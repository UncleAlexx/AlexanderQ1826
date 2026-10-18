package by.itstep.lesson10;

import by.itstep.lesson10.common.*;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class Program {

    static void main() {
        Integer[] numbers = {1, 2, 5, 3, 4, 7, 228};
        ArraysStats<Integer> stats = new ArraysStats<>(numbers);
        var minMax = stats.minMax();
        out.printf("Min: %d\nMax: %d\n", minMax.min().orElse(0), minMax.max().orElse(0));
        stats.skip(5).forEach(out::println);
        System.out.printf("Sum of even: %d\n", stats.filter(x -> x % 2 == 0).reduce(Integer::sum).orElse(0));

        int[] numbers1 = {1, 2, 5, 3, 4, 7, 228};
        out.printf("Min: %d\nMax: %d\n", IntStream.of(numbers1).min().orElse(0), IntStream.of(numbers1).max().orElse(0));
        IntStream.of(numbers1).skip(5).forEach(out::println);
        System.out.printf("Sum of even: %d\n", IntStream.of(numbers1).filter(x -> x % 2 == 0).sum());
        List<Child> children1 = new ArrayList<>();

        children1.add(new Child("Alice", 10, false));
        children1.add(new Child("Bob2", 12, true));
        children1.add(new Child("Charlie", 8, true));

        List<Child> children2 = new ArrayList<>();
        children2.add(new Child("Diana", 7, false));
        children2.add(new Child("Et2han", 14, true));
        children2.add(new Child("Fiona", 9, false));

        Parent parent1 = new Parent("John", 40, children1);
        Parent parent2 = new Parent("Maria", 38, children2);

        // Список родителей
        List<Parent> parents = new ArrayList<>();
        parents.add(parent1);
        parents.add(parent2);

        var children = parents.stream().mapMulti((Parent x, Consumer<Child> y) ->{
            for (Child child : x.getChildren()) {
                y.accept(child);
            }
        }).toList();

        out.println(ChildHelpers.filter(children, c -> c.getName().contains("2")));
        out.println(ParentsHelpers.filter(parents, p -> p.getChildren().size() > 2));
        out.println(ChildHelpers.filter(children, Child::getIsMan));
        out.println(ChildHelpers.filter(children, c -> !c.getIsMan()));
        children.stream().map(Child::getName).map(String::toUpperCase).forEach(out::println);
        out.println(ParentsHelpers.childrenCount(parents));
        out.println(ParentsHelpers.toMap(parents, Parent::getName, p -> p.getChildren().size()));
    }}
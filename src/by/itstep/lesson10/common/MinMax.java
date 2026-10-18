package by.itstep.lesson10.common;

import java.util.Optional;

public record MinMax<T extends Optional<T2>, T2 extends Number>(T min, T max){
}
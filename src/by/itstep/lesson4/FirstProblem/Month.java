package by.itstep.lesson4.FirstProblem;

import java.util.Locale;

public enum Month {

    DECEMBER,
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER;

    private static Season[] _seasons = Season.values();

    public String getSeason(){
        return _seasons[Month.valueOf(name()).ordinal() % 3].name();
    }

}

package by.itstep.lesson9.part2.Enums;

public enum SortOrder {
    ASC(1),
    DESC(-1);

    public final int value;

    SortOrder(int value) {
        this.value = value;
    }
}

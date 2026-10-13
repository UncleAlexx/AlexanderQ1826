package by.itstep.lesson8.Interfaces;

public interface InputStore<T> {
    T retrieve();

    T save();
}

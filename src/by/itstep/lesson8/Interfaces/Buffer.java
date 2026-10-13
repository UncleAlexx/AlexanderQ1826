package by.itstep.lesson8.Interfaces;

public interface Buffer<T> {
    public T pop();
    public void push(T element);
    public T peek();
    public int getSize();
    public boolean isEmpty();
}

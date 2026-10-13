package by.itstep.lesson8.Exceptions;

public class LimitedBufferEmptyException extends RuntimeException {
    private final static String EMPTY_MESSAGE = "Buffer is empty";

    public LimitedBufferEmptyException() {
        super(EMPTY_MESSAGE);
    }
}

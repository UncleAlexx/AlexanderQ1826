package by.itstep.lesson8.Exceptions;

public class OutOfLimitedBufferException extends RuntimeException{

    private final static String OUT_OF_BUFFER_MESSAGE = "Cannot push element \"{%s}\" to memory, buffer limit is reached \"limit is {%d}\"";

    public <T>OutOfLimitedBufferException(int limit, T elem) {
        super(OUT_OF_BUFFER_MESSAGE.formatted(elem, limit));
    }
}

package by.itstep.lesson8.Services;

import by.itstep.lesson8.Abstractions.AbstractBuffer;
import by.itstep.lesson8.Exceptions.LimitedBufferEmptyException;
import by.itstep.lesson8.Exceptions.OutOfLimitedBufferException;
import by.itstep.lesson8.Extensions.IntExtensions;

import java.util.*;

public final class LimitedBuffer<T> extends AbstractBuffer<T> {
    public final int limit;
    public final static int DEFAULT_LIMIT = 10;

    private final Stack<T> buffer;

    public LimitedBuffer(int limit) {
        super(buffer = new Stack<>());
        limit = IntExtensions.positiveOrDefault(limit, DEFAULT_LIMIT);
        buffer.ensureCapacity(limit);
        this.limit = limit;
    }

    public void push(T element) throws OutOfLimitedBufferException{
        if (buffer.size() == limit)
            throw new OutOfLimitedBufferException(limit, element);
        buffer.push(element);
    }

    public T pop() throws LimitedBufferEmptyException{
        if(buffer.empty())
            throw new LimitedBufferEmptyException();
        return buffer.pop();
    }

    public T peek() {
        return buffer.peek();
    }

    public Collection<T> getUnmodifiableBuffer() {
        return Collections.unmodifiableCollection(buffer);
    }
}

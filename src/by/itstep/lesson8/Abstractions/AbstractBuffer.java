package by.itstep.lesson8.Abstractions;

import by.itstep.lesson8.Interfaces.Buffer;

import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractBuffer<T> implements Buffer<T>, Iterable<T> {

    public final Collection<T> buffer;

    public AbstractBuffer(Collection<T> internalBuffer){
        this.buffer = internalBuffer;
    }

    public abstract Collection<T> getUnmodifiableBuffer();

    public int getSize() {
        return buffer.size();
    }

    public boolean isEmpty() {
        return buffer.isEmpty();
    }

    @Override
    public String toString() {
        return  buffer.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return buffer.iterator();
    }
}

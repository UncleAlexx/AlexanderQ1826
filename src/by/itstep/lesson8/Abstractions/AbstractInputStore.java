package by.itstep.lesson8.Abstractions;

import by.itstep.lesson8.Interfaces.Buffer;
import by.itstep.lesson8.Interfaces.InputStore;
import by.itstep.lesson8.Wrappers.InputWrapper;

public abstract class AbstractInputStore<TInputWrapper extends InputWrapper<TInput, TInputSource>,
        TInputSource, TInput> implements InputStore<TInput> {
    private final Buffer<TInput> buffer;
    private final TInputWrapper inputReader;
    public final boolean isReadSkippable;
    private TInput current;
    private boolean isInputRead;

    protected AbstractInputStore(Buffer<TInput> buffer, TInputWrapper input, boolean isReadSkippable) {
        this.buffer = buffer;
        this.isReadSkippable = isReadSkippable;
        this.inputReader = input;
    }

    protected AbstractInputStore(Buffer<TInput> buffer, TInputWrapper input) {
        this(buffer, input, false);
    }

    public void skipCurrent(){
        if(isReadSkippable && isInputRead)
            isInputRead = false;
    }

    public boolean getIsInputRead() {
        return isInputRead;
    }

    @Override
    public TInput retrieve() {
        return buffer.pop();
    }

    @Override
    public TInput save() {
        if(isInputRead){
            buffer.push(current);
            isInputRead = false;
            return  current;
        }
        return null;
    }

    public TInput readNext(){
        if (isInputRead)
            return null;
        isInputRead = true;
        current = inputReader.read();
        return current;
    }

    @Override
    public String toString() {
        return buffer.toString();
    }
}

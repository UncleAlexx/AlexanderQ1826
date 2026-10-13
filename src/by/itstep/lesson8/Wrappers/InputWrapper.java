package by.itstep.lesson8.Wrappers;

public abstract class InputWrapper<TInput, TInputSource>{
    public final TInputSource inputSource;

    public InputWrapper(TInputSource inputSource) {
        this.inputSource = inputSource;
    }

    public abstract TInput read  ();
}

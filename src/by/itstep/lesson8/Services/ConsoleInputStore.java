package by.itstep.lesson8.Services;

import by.itstep.lesson8.Abstractions.AbstractInputStore;
import by.itstep.lesson8.Exceptions.LimitedBufferEmptyException;
import by.itstep.lesson8.Exceptions.OutOfLimitedBufferException;
import by.itstep.lesson8.Constants.Patterns;
import by.itstep.lesson8.Wrappers.InputWrapper;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.regex.Matcher;

public class ConsoleInputStore extends AbstractInputStore<InputWrapper<String, Scanner>, Scanner, String> {
     public Predicate<String> saveCondition;

     protected ConsoleInputStore(int storeLimit, Predicate<String> savePredicate) {
         super(new LimitedBuffer<>(storeLimit), new InputWrapper<>(new Scanner(System.in)) {
            @Override
            public String read() {
                return inputSource.next();
            }
        }, true);
         this.saveCondition = savePredicate;
    }

    @Override
    public String retrieve() throws LimitedBufferEmptyException {
        return super.retrieve();
    }

    @Override
    public String readNext(){
        if(getIsInputRead())
            return null;
        var input = super.readNext();
        Matcher matcher = Patterns.trimPattern.matcher(input);
        return matcher.hasMatch()? matcher.group(1) : input;
    }

    @Override
    public String save() throws OutOfLimitedBufferException {
        var input = readNext();

        if(!saveCondition.test(input)) {
            return super.save();
        }
        skipCurrent();
        return input;
    }
}

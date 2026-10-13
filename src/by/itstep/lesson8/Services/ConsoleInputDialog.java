package by.itstep.lesson8.Services;

import by.itstep.lesson8.Abstractions.AbstractInputStore;
import by.itstep.lesson8.Exceptions.LimitedBufferEmptyException;
import by.itstep.lesson8.Exceptions.OutOfLimitedBufferException;
import by.itstep.lesson8.Wrappers.InputWrapper;

import javax.annotation.processing.ProcessingEnvironment;
import java.util.Scanner;

public class ConsoleInputDialog {
    private final AbstractInputStore<InputWrapper<String, Scanner>, Scanner, String> store;
    private final String stopRaw;
    private final String getRaw;
    private final String INPUT_A_STRING_RAW = "Введите строку:";
    private final String INPUTTED_STRING_RAW = "Введеная строка: ";
    private final String DELETED_STRING_RAW = "Удаляем строку: ";
    private final String COLLECTION_RAW = "Коллекция: ";

    public ConsoleInputDialog(String stopWord, String getRaw) {
        this.stopRaw = stopWord;
        this.getRaw = getRaw;
        store = new ConsoleInputStore(  -4, x-> x != null && x.equalsIgnoreCase(getRaw));
    }

    public void ShowDialog(){
        try{
        System.out.println(INPUT_A_STRING_RAW);
        String fetched = store.save();
        System.out.println( INPUTTED_STRING_RAW + fetched);
        while (!fetched.equalsIgnoreCase(stopRaw)){
            if(fetched.equalsIgnoreCase(getRaw)) {
                System.out.println(DELETED_STRING_RAW + store.retrieve());
            }
            System.out.println(COLLECTION_RAW + store);
            System.out.println(INPUT_A_STRING_RAW);
            fetched = store.save();
            System.out.println(INPUTTED_STRING_RAW + fetched);
        }}
        catch (OutOfLimitedBufferException | LimitedBufferEmptyException e){
            System.out.println("Exception " +e.getMessage());
        }

    }
}

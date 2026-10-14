package by.itstep.lesson9.part1;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public final class TextAnalyzer {
    public static final Integer[] ALL_LETTERS = IntStream.concat(IntStream.concat(IntStream.rangeClosed('а', 'е'), IntStream.of('ё')),
            IntStream.rangeClosed('ж', 'я')).boxed().toArray(Integer[]::new);

    public String text;

    private final static Pattern wordPattern = Pattern.compile("(?<=\\P{P}|)([a-zA-Zа-яА-ЯёЁ]+)");;

    public TextAnalyzer(String text) {
        this.text = text;
    }

    public int getWordsCount () {
        return  text.split(" ").length;
    }

    public String getTheLongestWord(){
        String[] words =  text.split(" ");
        String max = words[0];
        for(int i = 1; i < words.length; i++){
            if(words[i].length() > max.length()){
                max = words[i];
            }
        }
        return max;
    }

    public String  reverseEachWord(){
        StringBuilder sb = new StringBuilder();
        var currentPosition = 0;
        var matcher = wordPattern.matcher(text);
        while (matcher.find()){
            for(int i = currentPosition; i < matcher.start();i++){
                sb.append(text.charAt(i));
            }
            for(int i = matcher.end() - 1; i >= matcher.start();i--){
                sb.append(text.charAt(i));
            }
            currentPosition = matcher.end();
        }
        for(int i = sb.length(); i < text.length();i++){
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }

    public boolean  isPhrasePolyndrome(){
        var matcher = wordPattern.matcher(text);
        StringBuilder onlyWords = new StringBuilder();
        while (matcher.find()) {
            onlyWords.append(matcher.group());
        }
        for (int i = 0; i < onlyWords.length();i++){
            if (onlyWords.charAt(i) != onlyWords.charAt(onlyWords.length() - i - 1)){
                return false;
            }
        }
        return true;
    }

    public int[] getEachLetterCount(){
        var lettersCounts = new int[33];
        int inAlphabetIndex;
        for (int i = 0; i < text.length(); i++) {
            inAlphabetIndex = Arrays.binarySearch(ALL_LETTERS, (int) Character.toLowerCase(text.charAt(i)),
                    new Comparator<Integer>(){
                private static final int  NEXT_TO_RUS_IO_CHAR_CODE = 'ё' + 1;
                private static final int DZE_RUS_CODE = 'ж';
                private static final int NEXT_TO_RUS_IO_CHAR_MINUS_DZE = NEXT_TO_RUS_IO_CHAR_CODE - DZE_RUS_CODE ;

                @Override
                public int compare(Integer a, Integer b) {
                    a = setIfInRange(a, 'ж', 'я', NEXT_TO_RUS_IO_CHAR_MINUS_DZE + a);
                    b = setIfInRange(b, 'ж', 'я', NEXT_TO_RUS_IO_CHAR_MINUS_DZE + b);
                    return a.compareTo(b);
                }

                private int setIfInRange(int oldValue, int lower, int upper, int NewValue){
                    return oldValue <= upper && oldValue >= lower? NewValue : oldValue;
                }
            });
            if(inAlphabetIndex >= 0) {
                lettersCounts[inAlphabetIndex]++;
            }
        }
        return  lettersCounts;
    }
}

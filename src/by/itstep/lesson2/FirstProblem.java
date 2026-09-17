package by.itstep.lesson2;

public class FirstProblem {

    private static final String NOT_LETTER_MESSAGE = "Not a letter";
    private static final String VOWEL_MESSAGE = "A vowel";
    private static final String CONSONANT_MESSAGE = "A consonant";

    public String GetIsVowelMessageWithSwitch(char letter){

        if(Integer.compareUnsigned(letter - 'a', 'z' - 'a') <= 0){
            switch (letter){
                case 'a': case 'e': case 'i': case 'o': case 'u':
                    return VOWEL_MESSAGE;
                default:
                    return CONSONANT_MESSAGE;
            }
        }
        return NOT_LETTER_MESSAGE;
    }

    public boolean isVowel(char letter) {
        return letter == 'a' || letter == 'i' || letter == 'u' || letter == 'e' || letter == 'o';
    }

    public String GetIsVowelMessageWithIf(char letter){

        letter = Character.toLowerCase(letter);

        if(Integer.compareUnsigned(letter - 'a', 'z' - 'a') <= 0)
            return isVowel(letter)? VOWEL_MESSAGE : CONSONANT_MESSAGE;

        return NOT_LETTER_MESSAGE;
    }
}
package by.itstep.lesson2;

import static java.lang.System.out;

public class FirstProblem {

    public void PrintVowelOrConsonantSwitch(char letter){
        if (Character.isLetter(letter)) {
            letter = Character.toLowerCase(letter);
        }

        switch (letter){
            case 'a': case 'e': case 'i': case 'o': case 'u':
                out.println("Гласная");
                break;
            case 'b': case 'c': case 'd': case 'f': case 'g':
            case 'h': case 'j': case 'k': case 'l': case 'm':
            case 'n': case 'p': case 'q': case 'r': case 's':
            case 't': case 'v': case 'w': case 'x': case 'y': case 'z':
                out.println("Согласная");
                break;
            default:
                out.println("Не буква");
        }
    }

    public void PrintVowelOrConsonant(char letter){
        if(Character.isLetter(letter))
        {
            letter = Character.toLowerCase(letter);
        }

        if (((((letter >> 1) & 1) ^ (letter>> 2 & 1)) == 0 && (letter & 0b11111001) == 0b01101001)
                || (letter & 0b11111011) == 0b01100001 || (letter & 0b11111001) == 0b11111001)
        {
            out.println(letter +" гласная");
        }
        else if(Integer.compareUnsigned(letter - 'a', 'z' - 'a') <= 0)
        {
            out.println(letter +" согласная");
        }
        else
        {
            out.println("i не буква");
        }
    }
}
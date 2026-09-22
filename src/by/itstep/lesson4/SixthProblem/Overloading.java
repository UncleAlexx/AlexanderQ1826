package by.itstep.lesson4.SixthProblem;

public class Overloading {
    /*method1(int)' clashes with 'method1(int)'; both methods have same erasure
    public int method1(int a){
        return 1;
    }*/
    public char method1(int a){
        return 's';
    }

    public int method1(String a){
        return a.length();
    }

    public int method1(String a, int b){
        return a.length();
    }
}

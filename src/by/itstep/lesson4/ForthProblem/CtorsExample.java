package by.itstep.lesson4.ForthProblem;

public class CtorsExample{

    private  String value1, value2;

    private CtorsExample() {
        super();
        System.out.println("empty");
    }

    private CtorsExample(String value) {
        this();
        System.out.println("ctor 1 param");
    }

    public CtorsExample(String value, String value1) {
        this(value);
        value1 = value;
        value2 = value1;
        System.out.println("ctor 2 params");
    }
}

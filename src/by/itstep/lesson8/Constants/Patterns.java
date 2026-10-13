package by.itstep.lesson8.Constants;

import java.util.regex.Pattern;

public abstract class Patterns {
    public static final Pattern trimPattern = Pattern.compile("^[ \\t]*([^ \\t](?:.*[^ \\t])?)[ \\t]*$");
}

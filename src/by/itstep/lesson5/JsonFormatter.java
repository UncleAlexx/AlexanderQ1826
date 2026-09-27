package by.itstep.lesson5;

public final class JsonFormatter {

    private static final char[] chars = {'0','1','2','3','4','5','6','7','8','9'};

    public static String cutCurlyBracesAndIdentations(String json){
        int jsonLastDigitIndex = 0;
        for (int i = json.length() - 1; i >= 0;i--){
            for (char aChar : chars) {
                if (aChar == json.charAt(i)) {
                    jsonLastDigitIndex = i;
                    break;
                }
            }
        }

        return json.substring(json.indexOf('"'), Math.max(json.lastIndexOf('"'), jsonLastDigitIndex) + 1);
    }
}

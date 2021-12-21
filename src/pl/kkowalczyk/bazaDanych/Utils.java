package pl.kkowalczyk.bazaDanych;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Locale;

public class Utils {

    public static boolean isNumeric(String string) {
        int intValue;

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {

        }
        return false;
    }

    private static String[] forbiddenNames =
    {
        "create", "help", "insert", "into", "id", "quit", "select", "show", "use", "from"
    };

    public static boolean isNameLegal(String name)
    {
        return !Arrays.stream(forbiddenNames).anyMatch(a -> name.toLowerCase().equals(a));
    }
}

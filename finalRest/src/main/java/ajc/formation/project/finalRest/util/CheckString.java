package ajc.formation.alten.finalRest.util;

import ajc.formation.alten.finalRest.exception.StringException;

public class CheckString {
    
    public static void checkStringIsNotNullNorEmpty(String string) {
        if (string == null || string.isEmpty()) {
            throw new StringException("String is null");
        }
    }
}

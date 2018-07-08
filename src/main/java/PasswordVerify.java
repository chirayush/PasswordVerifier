import org.apache.commons.lang3.CharUtils;

final class PasswordVerify {
    boolean verify(final String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password Should Not Be Null");
        }
        if (!hasLowercase(password)) {
            throw new IllegalArgumentException("Password Should Have Atleast 1 lowercase letter");
        }
        int num = 2;
        if (hasSufficientLength(password)) num--;
        if (hasUppercase(password)) num--;
        if (hasNumeric(password)) num--;

        if (num <= 0) return true;

        if (!hasUppercase(password)) {
            throw new IllegalArgumentException("Password Should Have Atleast 1 uppercase letter");
        }
        if (!hasNumeric(password)) {
            throw new IllegalArgumentException("Password Should Have Atleast 1 Numeric");
        }
        if (!hasSufficientLength(password)) {
            throw new IllegalArgumentException("Password should Be Atleast 8 characters long");
        }

        return true;
    }

    private boolean hasSufficientLength(String password) {
        return password.length() > 8;
    }

    private boolean hasNumeric(String password) {
        char[] passChars = password.toCharArray();
        for (char passChar : passChars) {
            if (CharUtils.isAsciiNumeric(passChar)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasLowercase(String password) {
        char[] passChars = password.toCharArray();
        for (char passChar : passChars) {
            if (CharUtils.isAsciiAlphaLower(passChar)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasUppercase(String password) {
        char[] passChars = password.toCharArray();
        for (char passChar : passChars) {
            if (CharUtils.isAsciiAlphaUpper(passChar)) {
                return true;
            }
        }
        return false;
    }
}

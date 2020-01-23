package com.company;

public class UserUtils {

    public static boolean ValidChars(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!ValidChar(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    static boolean ValidChar(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        return false;
    }
}

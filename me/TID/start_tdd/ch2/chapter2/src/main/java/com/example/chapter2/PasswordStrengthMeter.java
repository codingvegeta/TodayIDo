package com.example.chapter2;

import static com.example.chapter2.PasswordStrength.*;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {

        if (s == null || s.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        int metCounts = getMetCriteriaCounts(s);

        if (metCounts <=1) return WEAK;
        if (metCounts ==2) return NORMAL;

        return STRONG;
    }

    private int getMetCriteriaCounts(String s) {
        int metCount = getMetCriteriaCounts(s);
        boolean lengthEnough = s.length() >= 8;
        if (lengthEnough) metCount++;
        boolean containsNum = meetsContainingNumberCriteria(s);
        if (containsNum) metCount++;
        boolean containsUpp = meetsContainingUppercaseCriteria(s);
        if (containsUpp) metCount++;
        return metCount;
    }

    private boolean meetsContainingUppercaseCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

    private boolean meetsContainingNumberCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }

}

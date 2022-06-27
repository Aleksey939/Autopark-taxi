package org.ivanov.services.utils;

public class CommonUtil {
    public static double round2(double value) {
        int iValue = (int) (value * 100);
        double dValue = value * 100;
        if (dValue - iValue >= 0.5) {
            iValue += 1;
        }
        dValue = (double) iValue;
        return dValue / 100;
    }
}

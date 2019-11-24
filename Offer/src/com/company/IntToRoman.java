package com.company;

import java.util.HashMap;
import java.util.Map;

public class IntToRoman {
    public static void main(String[] args) {
        intToRoman(1994);
    }

    public static String intToRoman(int num) {
        Map map = new HashMap();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        int unit = 0, decade = 0, hundreds = 0, kilobit = 0;
        int position = 1; // 个位开始
        while (num > 0) {
            int x = num % 10;
            switch (position) {
                case 1:
                    unit = x;
                    break;
                case 2:
                    decade = x;
                    break;
                case 3:
                    hundreds = x;
                    break;
                case 4:
                    kilobit = num;
                    break;
            }
            num = num / 10;
            position++;
        }
        String result = "";
        // 先添加 千位
        for (int i = 0; i < kilobit; i++) {
            result = result + map.get(1000);
        }
        // 添加百位
        switch (hundreds) {
            case 1:
                result = result + "C";
                break;
            case 2:
                result = result + "CC";
                break;
            case 3:
                result = result + "CCC";
                break;
            case 4:
                result = result + "CD";
                break;
            case 5:
                result = result + "D";
                break;
            case 6:
                result = result + "DC";
                break;
            case 7:
                result = result + "DCC";
                break;
            case 8:
                result = result + "DCCC";
                break;
            case 9:
                result = result + "CM";
                break;
        }
        // 十位
        switch (decade) {
            case 1:
                result = result + "X";
                break;
            case 2:
                result = result + "XX";
                break;
            case 3:
                result = result + "XXX";
                break;
            case 4:
                result = result + "XL";
                break;
            case 5:
                result = result + "L";
                break;
            case 6:
                result = result + "LX";
                break;
            case 7:
                result = result + "LXX";
                break;
            case 8:
                result = result + "LXXX";
                break;
            case 9:
                result = result + "XC";
                break;
        }
        // 个位
        switch (unit) {
            case 1:
                result = result + "I";
                break;
            case 2:
                result = result + "II";
                break;
            case 3:
                result = result + "III";
                break;
            case 4:
                result = result + "IV";
                break;
            case 5:
                result = result + "V";
                break;
            case 6:
                result = result + "VI";
                break;
            case 7:
                result = result + "VII";
                break;
            case 8:
                result = result + "VIII";
                break;
            case 9:
                result = result + "IX";
                break;
        }

        return result;
    }
}

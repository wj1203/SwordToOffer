package com.company;

public class MyAtoi {
    public static void main(String[] args) {
            myAtoi("2147483648");
    }


    //   4ms  61.12%
    public static int myAtoi(String str) {
        String string = " ";
        for (int i = 0;i<str.length();i++){
            if (str.charAt(i)!=' '){
                string = str.substring(i);
                break;
            }
        }
        boolean isPositive = true;
        int result = 0;
        if (Character.isDigit(string.charAt(0)) || string.charAt(0) == '-' ||  string.charAt(0) == '+'){
            if (string.charAt(0) == '-'){
                isPositive = false;
                string = string.substring(1);
            }else if (string.charAt(0) == '+'){
                isPositive = true;
                string = string.substring(1);
            }
            for (int i = 0;i<string.length();i++){
                if (Character.isDigit(string.charAt(i)) ){
                    // 判断  正负溢出
                    if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && Integer.valueOf(string.substring(i,i+1)) >7) ){
                        return isPositive?Integer.MAX_VALUE:Integer.MIN_VALUE;
                    }
                    result = result*10 + Integer.valueOf(string.substring(i,i+1));
                }else {
                    break;
                }
            }
        }else {
            return 0;
        }
        if (!isPositive){
            result = result*-1;
        }
        return result;
    }

}

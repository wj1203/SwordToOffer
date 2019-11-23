package com.company;

public class IsPalindrome {
    public static void main(String[] args) {
            isPalindrome1(121);
    }


    //  14ms  44.4%
    public static boolean isPalindrome(int x) {
        boolean isP = true;
        String string = String.valueOf(x);
        for (int i = 0;i<string.length();i++){
            if (string.charAt(i) != string.charAt(string.length()-1-i)){
                isP = false;
            }
        }
        return isP;
    }

    //  优解
    public static boolean isPalindrome1(int x){
        if (x>0){
            int origin = x;
            int y = 0,z = 0;
            while (x!=0){
                z = x%10;
                x = x/10;
                y = y * 10 + z;
            }
            return origin == y;
        }else {
            return false;
        }
    }
}

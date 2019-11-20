package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class LongestPalindrome {
    public static void main(String[] args) {
        longestPalindrome1("bc");
//        System.out.println(spandInCenter("44211232",6));
    }

    //  中心扩散法       69ms  44.4%
    public static String longestPalindrome1(String s) {
        if (s.length()<=1){
            return s;
        }
        if (s.length() == 2){
            return s.charAt(0) == s.charAt(1)? s:s.substring(0,1);
        }
        int  len = s.length();
        int maxLen = 0;
        String maxString = "";
        for (int i = 0;i<len*2-3;i++){
            String string = spandInCenter(s,i);
            if (string.length()>maxLen){
                maxString = string;
                maxLen = maxString.length();
            }
        }
        return maxString;
    }
    private static String spandInCenter(String s,int index){
        int center = 0;
        if (index%2 ==0){   // 偶数，无中心扩散
            center = index/2;
            int before = center,after = center+1;
            while (before>=0 && after<s.length()){
                if (s.charAt(before) != s.charAt(after) ){
                    return s.substring(before+1,after);
                }else if(before == 0){
                    return s.substring(0,after+1);
                }else if (after == s.length()-1) {
                    return s.substring(before);
                }else {
                    before--;
                    after++;
                }
            }
        }else {             // 基数，有中心扩散
            center = (index + 1)/2;
            int before = center-1,after = center+1;
            while (before>=0 && after<s.length()){
                if (s.charAt(before) != s.charAt(after) ){
                    return s.substring(before+1,after);
                }else if(before == 0){
                    return s.substring(0,after+1);
                }else if (after == s.length()-1) {
                    return s.substring(before);
                }else {
                    before--;
                    after++;
                }
            }
        }
        return "";
    }

    // 动态规划法        368 ms   11.4%
    public static String longestPalindrome(String s) {
        String result = "";
        int len = s.length();
        boolean[][] isPalindrom = new boolean[len][len];
        for (int i = len; i >= 0 ; i--) {
            for (int j = i; j < len; j++) {
                if (i == j){
                    isPalindrom[i][j] = true;
                }else if( j - i == 1){
                    isPalindrom[i][j] = s.charAt(i) == s.charAt(j);
                }else {
                    isPalindrom[i][j] = isPalindrom[i+1][j-1]&&s.charAt(i) == s.charAt(j);
                }
                if (isPalindrom[i][j] && result.length()<s.substring(i,j+1).length()){
                    result = s.substring(i,j+1);
                }
            }
        }
        return result;
    }
    //  暴力破解，oj超时
//    public static String longestPalindrome(String s) {
//        String  result = "";
//
//        for(int i = 0;i<s.length();i++){
//            for (int j= i; j<=s.length();j++){
//                String string = s.substring(i,j);
//                System.out.println(string);
//                if (isPalind(string)){
//                    if (result.length()<string.length()){
//                        result = string;
//                    }
//                }
//            }
//        }
//        return result;
//    }
//    private static boolean isPalind(String s){
//        String string = "";
//        for (int i = s.length()-1;i>=0;i--){
//            string = string + s.charAt(i);
//        }
//        if (string.equals(s)){
//            return true;
//        }else {
//            return false;
//        }
//    }
}

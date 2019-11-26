package com.company;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = {"fl23", "fl55","fl13"};
        longestCommonPrefix(strings);
        get(strings);
    }

    //   2ms 55.7%
    public static String longestCommonPrefix(String[] strs) {
        int num = 0;
        if (strs.length == 0) {
            return "";
        }
        for (int i = 0; ; i++) {
            String s = "";
            if (strs[0].length() > i) {
                s = strs[0].substring(i, i + 1);
            } else {
                break;
            }
            boolean flag = false;
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length()>i){
                    if (!s.equals(strs[j].substring(i, i + 1))) {
                        flag = true;
                    }
                }else {
                    flag = true;
                }
            }
            if (flag) {
                break;
            } else {
                num++;
            }
        }
        return num == 0 ? "" : strs[0].substring(0, num);
    }

    //   官方  0ms  100%     水平扫描
    //   选择第一个String，与剩下的String对比，是否是其的开头，如果不是就切掉最后一个char，直到是对比的String的开头
    public static String get(String[] strs){
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;

    }
}

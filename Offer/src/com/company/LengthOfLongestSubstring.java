package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        String tempString = "";
        Queue queue = new LinkedList();
        for (int i = 0;i<s.length();i++){
            String string = s.substring(i,i+1);
            if (queue.contains(string)){
                String temp = "";
                while (!temp.equals(string)){
                    temp = (String) queue.remove();
                }
                queue.add(string);
            }else {
                queue.add(string);
            }
            if (max < queue.size()){
                max = queue.size();
            }
        }
        return max;
    }


}

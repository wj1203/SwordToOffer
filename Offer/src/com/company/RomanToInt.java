package com.company;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static void main(String[] args) {
        romanToInt("III");
    }

    //   map 的 get 会耗时，可以换成switch
    public static int romanToInt(String s) {
        int unit = 0, decade = 0, hundreds = 0, kilobit = 0;
        Map<String,Integer> map = new HashMap();
        map.put( "I",1);
        map.put( "V",5);
        map.put( "X",10);
        map.put( "L",50);
        map.put( "C",100);
        map.put( "D",500);
        map.put( "M",1000);
        int result = 0;
        for (int i =0;i<s.length();i++){
            if (i == s.length()-1){
                int num = map.get(s.substring(i,i+1));
                result = result + num;
                break;
            }
            int cur = map.get(s.substring(i,i+1));
            int next = map.get(s.substring(i+1,i+2));
            if (cur == next || cur > next){
                result = result + cur;
            }else{
                result = result + next-cur;
                i++;
            }
        }
    return result;
    }



}

package com.company;

import java.util.ArrayList;

public class Reverse {
    public static void main(String[] args) {
        reverse(1534236469);
    }

    //  最捞解法  ： 4ms 22.4%
    public static int reverse1(int x) {
        boolean isPositive = true;
        if (x<0){
            x = x*-1;
            isPositive = false;
        }
        ArrayList<Integer> integers = new ArrayList<>();
        while (x>0){
            integers.add(x%10);
            x = x/10;
        }
        for (int i = 0;i<integers.size();i++){
            if (integers.get(0)!=0){
                break;
            }else {
                integers.remove(0);
            }
        }
        int result = 0;
        for (int i = 0; i<integers.size();i++){
            int num = integers.get(i);
            result = (int) (result + num*10*Math.pow(10,integers.size()-i-2));
            if (result == Integer.MAX_VALUE){
                return 0;
            }
        }
        if (isPositive){
            return  result;
        }else {
            return  result*-1;
        }
    }

    //  参考1   一层循环 无需额外空间
    public  static int reverse(int x){
        int result = 0;
        while (x!=0){
            int num = x%10;
            x = x/10;
            //  因为下面需要 *10  所以 如果比max /10 还要大 就算溢出
            if (result > Integer.MAX_VALUE/10 || result < Integer.MIN_VALUE/10){
                return 0;
            }
            result = result*10 + num;

        }
        return result;
    }
}

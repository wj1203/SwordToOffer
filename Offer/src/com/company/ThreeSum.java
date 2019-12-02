package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {0,0,-2,2,2};
        threeSum(nums);
    }

    //    四层for循环无脑法 超时了
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int need = 0 - nums[i] - nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    if (need == nums[k]) {
                        List<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        boolean isAdded = false;
                        for (int m = 0; m < result.size(); m++) {
                            if (isSame(result.get(m), list)) {
                                isAdded = true;
                            }
                        }
                        if (!isAdded) {
                            result.add(list);
                        }
                        break;
                    }
                }
            }
        }
        return result;
    }

    private static boolean isSame(List<Integer> list1, List<Integer> list2) {
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }

    //   优解
    /*
    *  排序，
    *  遍历0-num-2  k
    *   对于k 遍历 k+1到num-1 看是否三数为0
    *  对于连续重复的k i j 舍去
    *   最后一个测试用例打印不全，不知为啥
    * */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length<3){
            return result;
        }else if (nums.length == 3){
            if (nums[0]+nums[1]+nums[2]==0){
                List<Integer> list = new ArrayList();
                list.add(nums[0]);
                list.add(nums[1]);
                list.add(nums[2]);
                result.add(list);
            }
            return result;
        }
        // 排序
        ArrayList<Integer> numList = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            numList.add(nums[i]);
        }
        Collections.sort(numList);
        //  双指针  两头找
        for(int k = 0;k<numList.size()-2;k++){
            int i = k+1;
            int j = numList.size()-1;
            //  去除重复k
            if (k>0 && numList.get(k) == numList.get(k-1))
                continue;
            while (i<j) {
                int num = numList.get(i) + numList.get(j) + numList.get(k);
                if (num == 0){
                    List<Integer> list = new ArrayList();
                    list.add(numList.get(k));
                    list.add(numList.get(i));
                    list.add(numList.get(j));
                    result.add(list);
                    i++;
                    while (i<j&&numList.get(i) == numList.get(i-1))
                        i++;
                    j--;
                    while (i<j&&numList.get(j) == numList.get(j+1))
                        j--;
                }else if (num>0){
                    j--;
                    while (i<j&&numList.get(j) == numList.get(j+1))
                        j--;
                }else {
                    i++;
                    while (i<j&&numList.get(i) == numList.get(i-1))
                        i++;
                }
            }
        }
        return result;
    }


}

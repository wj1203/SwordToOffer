package com.company;

import java.util.ArrayList;

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1,3,5};
        int[] nums2 = {1};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> nums = new ArrayList();
        for (int i = 0, j = 0; i < nums1.length || j < nums2.length; ) {
            if (i == nums1.length) {
                for (int k = j; k < nums2.length; k++) {
                    nums.add(nums2[k]);
                }
                break;
            }
            if (j == nums2.length) {
                for (int k = i; k < nums1.length; k++) {
                    nums.add(nums1[k]);
                }
                break;
            }
            if (nums1[i] < nums2[j]) {
                nums.add(nums1[i++]);
            } else {
                nums.add(nums2[j++]);
            }
        }

        if (nums.size() % 2 == 0) {
            int index  = nums.size()/2;
            return (Double.valueOf(nums.get(index-1)) + nums.get(index))/2;
        } else {
            int index =( nums.size() -1 ) /2;
            return Double.valueOf(nums.get(index) );
        }
    }
}

package com.company;

public class MaxArea {
    public static void main(String[] args) {
        int [] h = {1,8,6,2,5,4,8,3,7};
        maxArea(h);
    }

    // 无脑选手：245 m   36.10%
    public static int maxArea1(int[] height) {
        int maxArea = 0;
        int h = 0, w = 0;
        for (int i = 0;i<height.length;i++){
            for (int j = i;j<height.length;j++){
                h = height[i]>height[j]?height[j]:height[i];
                w = j - i;
                if (maxArea< h * w){
                    maxArea = h * w;
                }
            }
        }
        return maxArea;
    }

    //   双指针法： i j 头尾开始走，哪一个短就舍去那一个，向中心靠拢
    /*  如果i j相等怎么办？？
    *   要么最大是 i，j 的子集，要么是 i ，j 本身，只有这两种情况，不可能出现一个i或者一个j 与中间一个x 组成最大，
    *   为什么，你 细细品
    *   所以如果相等，随便舍去i或者j都是一样的
    * */
    public static int maxArea(int[] height){
        int max = 0;
        int i = 0, j = height.length-1;
        while (i<j){
            if (height[i]<height[j]){
                max = max<(j-i)*height[i]?(j-i)*height[i]:max;
                i++;
            }else {
                max = max<(j-i)*height[j]?(j-i)*height[j]:max;
                j--;
            }
        }
        return max;
    }
}

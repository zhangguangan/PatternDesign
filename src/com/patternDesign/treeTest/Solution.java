package com.patternDesign.treeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 给定一个数组，从其中选取三个数，要求三个数的和必须是0，求出所有这样的组合
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {};
        System.out.println(new Solution().threeSum(nums1));
        int[] nums2 = {0, 0};
        System.out.println(new Solution().threeSum(nums2));
        int[] nums3 = {0, 0, 0};
        System.out.println(new Solution().threeSum(nums3));
        int[] nums4 = {-1, 0, 1, 2, -1, -4};
        System.out.println(new Solution().threeSum(nums4));
        int[] nums5 = {-1, 0, 1, 1, 2, 999999996, -999999998, 999999999, -1, -2};
        System.out.println(new Solution().threeSum(nums5));
        int[] nums6 = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        System.out.println(new Solution().threeSum(nums6));
    }

    /**
     * 快速排序算法结构
     * 选定初始值，设置两个哨兵j ,k
     * j从左往右扫描 k从右往左扫描，知道扫描到 选定的值 + j + k的值 = 0
     * 选定初始值，右移
     *
     * @param numbers
     * @return
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            int position = numbers[i];
            int j = i + 1;
            int k = numbers.length - 1;
            while (j < k) {
                int sum = position + numbers[j] + numbers[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(position);
                    list.add(numbers[j]);
                    list.add(numbers[k]);
                    set.add(list);
                    j++;
                    k--;
                }
            }
        }
        List<List<Integer>> lists = new ArrayList<>(set);
        return lists;

    }

}

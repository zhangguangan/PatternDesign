package com.patternDesign.amin;

public class Solution {


    public static int jump(int[] nums) {
        int arrayLength = nums.length;
        if (arrayLength <= 1)
            return 0;
        //当前位置能跳到的最远距离
        int curJumpMax = nums[0];
        //下一个位置能跳到的最远距离
        int nextJumpMax = nums[0];
        int step = 1;
        for (int currentIndex = 1; currentIndex < arrayLength; currentIndex++) {
            // 如果当前能跳的最大长度大于当前的坐标，就跳转到下一个位置
            if (curJumpMax < currentIndex) {
                curJumpMax = nextJumpMax;
                step++;
            }
            // 下个位置重置为当前索引+当前位置能跳的最大长度
            if (currentIndex + nums[currentIndex] > nextJumpMax) {
                nextJumpMax = currentIndex + nums[currentIndex];
            }
            // 当前能跳转的位置大于数组长度-1说明跳到终点了
            if (curJumpMax >= arrayLength - 1)
                return step;
        }
        return 0;

    }

    public static void main(String[] args) {
        int[] nums = {2 ,3, 1, 1, 4};
        System.out.println(jump(nums));
    }
}

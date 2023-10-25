package LeetCode.L31;

import java.util.Arrays;

/**
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 *
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 *
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] p1 = new int[]{1,2};
        s.nextPermutation(p1);
        System.out.println("p1 = " + Arrays.toString(p1));
        int[] p2 = new int[]{1,3,2};
        s.nextPermutation(p2);
        System.out.println("p2 = " + Arrays.toString(p2));
        int[] p3 = new int[]{3,2,1};
        s.nextPermutation(p3);
        System.out.println("p3 = " + Arrays.toString(p3));
        int[] p4 = new int[]{1,1,5};
        s.nextPermutation(p4);
        System.out.println("p4 = " + Arrays.toString(p4));
    }
}

class Solution {
    public void nextPermutation(int[] nums) {
        int tmp = nums[0];
        switch (nums.length){
            case 1:
                break;
            case 2:
                nums[0] = nums[1];
                nums[1] = tmp;
                break;
            default:
                int p = nums.length - 1;
                while (p > 0 && nums[p - 1] >= nums[p]){
                    p--;
                }
                if (p != 0){
                    int q = nums.length - 1;
                    while (nums[q] <= nums[p - 1]){
                        q--;
                    }
                    tmp = nums[p - 1];
                    nums[p - 1] = nums[q];
                    nums[q] = tmp;
                }
                sort(nums, p);
                break;
        }
    }
    private void sort(int[] source, int startx){
        for (int i = startx; i < source.length - 1; i++){
            boolean flag = true;
            for (int j = startx; j < source.length - i + startx - 1; j++) {
                if (source[j] > source[j + 1]) {
                    int tmp = source[j];
                    source[j] = source[j + 1];
                    source[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
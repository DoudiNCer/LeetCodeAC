package LeetCode.L2444;

/**
 * 给你一个整数数组 nums 和两个整数 minK 以及 maxK 。
 *
 * nums 的定界子数组是满足下述条件的一个子数组：
 *
 * 子数组中的 最小值 等于 minK 。
 * 子数组中的 最大值 等于 maxK 。
 * 返回定界子数组的数目。
 *
 * 子数组是数组中的一个连续部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,5,2,7,5], minK = 1, maxK = 5
 * 输出：2
 * 解释：定界子数组是 [1,3,5] 和 [1,3,5,2] 。
 * 示例 2：
 *
 * 输入：nums = [1,1,1,1], minK = 1, maxK = 1
 * 输出：10
 * 解释：nums 的每个子数组都是一个定界子数组。共有 10 个子数组。
 *
 *
 * 提示：
 *
 * - 2 <= nums.length <= 10^5
 * - 1 <= nums[i], minK, maxK <= 10^6
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5) = " + s.countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5));
    }
}

class Solution {
    private int[] nums;
    private int minK;
    private int maxK;

    public long countSubarrays(int[] nums, int minK, int maxK) {
        this.minK = minK;
        this.maxK = maxK;
        this.nums = nums;
        int start = 0;
        long result = 0;
        int minC = 0;
        int maxC = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == minK) {
                minC++;
            }
            if (nums[i] == maxK) {
                maxC++;
            }
            if (nums[i] > maxK || nums[i] < minK) {
                if (minC > 0 && maxC > 0) {
                    result += solve(start, i - 1);
                }
                start = i + 1;
                minC = 0;
                maxC = 0;
            }
        }
        result += solve(start, nums.length - 1);
        return result;
    }

    private long solve(int start, int end) {
        if (start < 0 || end > nums.length) {
            return 0;
        }
        long result = 0;
        int lm = start, mac = 0, mic = 0;
        for (int r = start; r <= end; r++) {
            if (nums[r] == minK) {
                mic++;
            }
            if (nums[r] == maxK) {
                mac++;
            }
            int ln = lm;
            while (mac > 0 && mic > 0) {
                if (nums[lm] == maxK) {
                    mac--;
                } else if (nums[lm] == minK) {
                    mic--;
                }
                lm++;
            }
            result += (long) (end - r + 1) * (lm - ln);
        }
        return result;
    }
}
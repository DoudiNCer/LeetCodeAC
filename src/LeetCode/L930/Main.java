package LeetCode.L930;

/**
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 *
 * 子数组 是数组的一段连续部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
 * 示例 2：
 *
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 *
 *
 * 提示：
 *
 * - 1 <= nums.length <= 3 * 10^4
 * - nums[i] 不是 0 就是 1
 * - 0 <= goal <= nums.length
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2) = " + s.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println("s.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0) = " + s.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
    }
}

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        if (goal == 0){
            int p = 0, cnt = 0;
            while (p < nums.length){
                if (nums[p] == 1){
                    p++;
                } else {
                    int zc = 0;
                    while (p < nums.length && nums[p] == 0){
                        zc++;
                        p++;
                    }
                    cnt += zc * (zc + 1) / 2;
                }
            }
            return cnt;
        } else {
            int lp = 0, rp = 0, sum = nums[0], cnt = 0;
            while (rp < nums.length){
                if (sum == goal){
                    int lc = 1;
                    while (nums[lp] == 0){
                        lc++;
                        lp++;
                    }
                    int rc = 1;
                    while (rp + 1 < nums.length && nums[rp + 1] == 0){
                        rp++;
                        rc++;
                    }
                    rp++;
                    if (rp < nums.length){
                        sum += nums[rp];
                    }
                    cnt += lc * rc;
                } else if (sum < goal){
                    rp++;
                    if (rp < nums.length){
                        sum += nums[rp];
                    }
                } else {
                    sum -= nums[lp];
                    lp++;
                }
            }
            return cnt;
        }
    }
}
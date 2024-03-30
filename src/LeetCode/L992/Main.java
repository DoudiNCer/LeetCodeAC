package LeetCode.L992;

/**
 * 给定一个正整数数组 nums和一个整数 k，返回 nums 中 「好子数组」 的数目。
 *
 * 如果 nums 的某个子数组中不同整数的个数恰好为 k，则称 nums 的这个连续、不一定不同的子数组为 「好子数组 」。
 *
 * 例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。
 * 子数组 是数组的 连续 部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,1,2,3], k = 2
 * 输出：7
 * 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * 示例 2：
 *
 * 输入：nums = [1,2,1,3,4], k = 3
 * 输出：3
 * 解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
 *
 *
 * 提示：
 *
 * - 1 <= nums.length <= 2 * 10^4
 * - 1 <= nums[i], k <= nums.length
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.helper(new int[]{1, 2, 1, 2, 3}, 2) = " + s.subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
    }
}

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int result = 0, lm = 0, ln = 0, cntm = 0, cntn = 0;
        int[] cntsm = new int[nums.length + 1], cntsn = new int[nums.length + 1];
        for (int num : nums) {
            if (cntsm[num] == 0) {
                cntm++;
            }
            if (cntsn[num] == 0) {
                cntn++;
            }
            cntsm[num]++;
            cntsn[num]++;
            while (cntm > k) {
                cntsm[nums[lm]]--;
                if (cntsm[nums[lm]] == 0) {
                    cntm--;
                }
                lm++;
            }
            while (cntn > k - 1) {
                cntsn[nums[ln]]--;
                if (cntsn[nums[ln]] == 0) {
                    cntn--;
                }
                ln++;
            }
            result += ln - lm;
        }
        return result;
    }
}
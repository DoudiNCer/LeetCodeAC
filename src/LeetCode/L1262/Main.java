package LeetCode.L1262;

/**
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * 示例 2：
 *
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * 示例 3：
 *
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 *
 *
 * 提示：
 *
 * - 1 <= nums.length <= 4 * 10^4
 * - 1 <= nums[i] <= 10^4
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.maxSumDivThree(new int[]{3, 6, 5, 1, 8}) = " + s.maxSumDivThree(new int[]{3, 6, 5, 1, 8}));
        System.out.println("s.maxSumDivThree(new int[]{4}) = " + s.maxSumDivThree(new int[]{4}));
    }
}

class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0, min1 = 10000, min11 = 10000, min2 = 10000, min22 = 10000;
        for (int num : nums) {
            sum += num;
            switch (num % 3) {
                case 1:
                    if (min1 > num) {
                        min11 = min1;
                        min1 = num;
                    } else if (min11 > num) {
                        min11 = num;
                    }
                    break;
                case 2:
                    if (min2 > num) {
                        min22 = min2;
                        min2 = num;
                    } else if (min22 > num) {
                        min22 = num;
                    }
                default:
            }
        }
        return switch (sum % 3) {
            case 1 -> sum - Math.min(min1, min2 + min22);
            case 2 -> sum - Math.min(min2, min1 + min11);
            default -> sum;
        };
    }
}
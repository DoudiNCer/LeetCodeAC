package LeetCode.L3153;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.sumDigitDifferences(new int[]{13,23,12}) = " + s.sumDigitDifferences(new int[]{13, 23, 12}));
    }
}

class Solution {
    public long sumDigitDifferences(int[] nums) {
        int n = nums.length;
        int[] cnts;
        long result = 0;
        while (nums[0] > 0){
            cnts = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            for (int i = 0; i < n; i++){
                cnts[nums[i] % 10]++;
                nums[i] /= 10;
            }
            long bc = 0;
            for (int cnt : cnts) {
                long c = cnt;
                c *= n - cnt;
                bc += c;
            }
            bc /= 2;
            result += bc;
        }
        return result;
    }
}
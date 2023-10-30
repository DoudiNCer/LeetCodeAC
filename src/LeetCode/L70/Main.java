package LeetCode.L70;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.climbStairs(1) = " + s.climbStairs(1));
        System.out.println("s.climbStairs(2) = " + s.climbStairs(2));
        System.out.println("s.climbStairs(6) = " + s.climbStairs(6));
        System.out.println("s.climbStairs(20) = " + s.climbStairs(20));
        System.out.println("s.climbStairs(45) = " + s.climbStairs(45));
    }
}

class Solution {
    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int[] cache = new int[n];
        cache[0] = 1;
        cache[1] = 2;
        return climbFast(n, cache);
    }
    private int climbFast(int n, int[] cache){
        if (cache[n - 1] != 0){
            return cache[n - 1];
        }
        cache[n - 1] = climbFast(n - 1, cache) + climbFast(n - 2, cache);
        return cache[n - 1];
    }
}
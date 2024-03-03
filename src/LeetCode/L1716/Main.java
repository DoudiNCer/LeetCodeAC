package LeetCode.L1716;

/**
 * Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。
 *
 * 最开始，他在周一的时候存入 1 块钱。从周二到周日，他每天都比前一天多存入 1 块钱。在接下来每一个周一，他都会比 前一个周一 多存入 1 块钱。
 *
 * 给你 n ，请你返回在第 n 天结束的时候他在力扣银行总共存了多少块钱。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：10
 * 解释：第 4 天后，总额为 1 + 2 + 3 + 4 = 10 。
 * 示例 2：
 *
 * 输入：n = 10
 * 输出：37
 * 解释：第 10 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37 。注意到第二个星期一，Hercy 存入 2 块钱。
 * 示例 3：
 *
 * 输入：n = 20
 * 输出：96
 * 解释：第 20 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8) = 96 。
 *
 *
 * 提示：
 *
 * - 1 <= n <= 1000
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.totalMoney(4) = " + s.totalMoney(4));
        System.out.println("s.totalMoney(10) = " + s.totalMoney(10));
        System.out.println("s.totalMoney(20) = " + s.totalMoney(20));
    }
}

class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;
        int result = 0;
        for (int i = 0; i < weeks; i++){
            result += 28;
            result += i * 7;
        }
        for (int i = 0; i < days; i++){
            result += weeks + i + 1;
        }
        return result;
    }
}
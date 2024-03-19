package LeetCode.L621;

import java.util.Arrays;

/**
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表，用字母 A 到 Z 表示，以及一个冷却时间 n。每个周期或时间间隔允许完成一项任务。任务可以按任何顺序完成，但有一个限制：两个 相同种类 的任务之间必须有长度为 n 的冷却时间。
 *
 * 返回完成所有任务所需要的 最短时间间隔 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
 *      在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
 * 示例 2：
 *
 * 输入：tasks = ["A","A","A","B","B","B"], n = 0
 * 输出：6
 * 解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
 * ["A","A","A","B","B","B"]
 * ["A","B","A","B","A","B"]
 * ["B","B","B","A","A","A"]
 * ...
 * 诸如此类
 * 示例 3：
 *
 * 输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 * 输出：16
 * 解释：一种可能的解决方案是：
 *      A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待命) -> (待命) -> A
 *
 *
 * 提示：
 *
 * - 1 <= tasks.length <= 10^4
 * - tasks[i] 是大写英文字母
 * - 0 <= n <= 100
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0) = " + s.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0));
        System.out.println("s.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2) = " + s.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println("s.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 3) = " + s.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 3));
        System.out.println("s.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 1) = " + s.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 1));
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0 || tasks.length < 2){
            return tasks.length;
        }
        int[] cnts = new int[26];
        int cnt = 0;
        for (char task : tasks) {
            if (cnts[task - 'A'] == 0){
                cnt++;
            }
            cnts[task - 'A']++;
        }
        if (cnt == tasks.length){
            return cnt;
        }
        Arrays.sort(cnts);
        int result = (cnts[25] - 1) * (n + 1) + 1;
        {
            int i = 24;
            while (i >= 0 && cnts[i] == cnts[25]){
                result++;
                i--;
            }
        }
        return Math.max(result, tasks.length);
    }
}
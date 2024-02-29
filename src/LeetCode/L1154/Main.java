package LeetCode.L1154;

/**
 * 给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。返回该日期是当年的第几天。
 *
 *
 *
 * 示例 1：
 *
 * 输入：date = "2019-01-09"
 * 输出：9
 * 解释：给定日期是2019年的第九天。
 * 示例 2：
 *
 * 输入：date = "2019-02-10"
 * 输出：41
 *
 *
 * 提示：
 *
 * - date.length == 10
 * - date[4] == date[7] == '-'，其他的 date[i] 都是数字
 * - date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.dayOfYear(\"2019-01-09\") = " + s.dayOfYear("2019-01-09"));
    }
}

class Solution {
    public int dayOfYear(String date) {
        int result = Integer.parseInt(date.substring(8));
        int month = Integer.parseInt(date.substring(5, 7));
        result += (new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334})[month - 1];
        if (month > 2){
            int year = Integer.parseInt(date.substring(0, 4));
            if (year % 4 == 0 && year != 1900){
                result += 1;
            }
        }
        return result;
    }
}
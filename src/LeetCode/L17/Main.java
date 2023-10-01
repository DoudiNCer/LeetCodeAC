package LeetCode.L17;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.letterCombinations(\"\") = " + s.letterCombinations(""));
        System.out.println("s.letterCombinations(\"2345\") = " + s.letterCombinations("2345"));
    }
}

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if (digits == null || digits.length() == 0){
            return result;
        }
        for (char c : this.getPressKey(digits.charAt(0))) {
            result.add(String.valueOf(c));
        }
        for (int i = 1; i < digits.length(); i++){
            List<String> tmp = new LinkedList<>();
            for (String s : result) {
                for (char c : getPressKey(digits.charAt(i))) {
                    tmp.add(s + c);
                }
            }
            result = tmp;
        }
        return result;
    }

    public char[] getPressKey(char ch){
        return switch (ch) {
            case '2' -> new char[]{'a', 'b', 'c'};
            case '3' -> new char[]{'d', 'e', 'f'};
            case '4' -> new char[]{'g', 'h', 'i'};
            case '5' -> new char[]{'j', 'k', 'l'};
            case '6' -> new char[]{'m', 'n', 'o'};
            case '7' -> new char[]{'p', 'q', 'r', 's'};
            case '8' -> new char[]{'t', 'u', 'v'};
            case '9' -> new char[]{'w', 'x', 'y', 'z'};
            default -> new char[]{};
        };
    }
}
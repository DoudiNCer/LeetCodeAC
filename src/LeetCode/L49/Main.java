package LeetCode.L49;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 *
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resx = new HashMap<>();
        for (String str : strs) {
            String s = hashStr(str);
            if (resx.containsKey(s)){
                resx.get(s).add(str);
            } else {
                List<String> sl = new ArrayList<>();
                sl.add(str);
                resx.put(s, sl);
            }
        }
        return new ArrayList<>(resx.values());
    }

    private String hashStr(String str){
        Map<Character, Integer> strmap = new TreeMap<>();
        for (char c : str.toCharArray()) {
            strmap.put(c, strmap.get(c) == null ? 1 : strmap.get(c) + 1);
        }
        return strmap.toString();
    }
}
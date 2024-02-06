package LeetCode.L1160;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *
 * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
 *
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 *
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 *
 *
 * 提示：
 *
 * - 1 <= words.length <= 1000
 * - 1 <= words[i].length, chars.length <= 100
 * - 所有字符串中都仅包含小写英文字母
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.countCharacters(new String[]{\"cat\", \"bt\", \"hat\", \"tree\"}, \"atach\") = " + s.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        System.out.println("s.countCharacters(new String[]{\"dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin\",\"ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb\",\"ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl\",\"boygirdlggnh\",\"xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx\",\"nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop\",\"hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx\",\"juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr\",\"lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo\",\"oxgaskztzroxuntiwlfyufddl\",\"tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp\",\"qnagrpfzlyrouolqquytwnwnsqnmuzphne\",\"eeilfdaookieawrrbvtnqfzcricvhpiv\",\"sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz\",\"yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue\",\"hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv\",\"cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo\",\"teyygdmmyadppuopvqdodaczob\",\"qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs\",\"qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs\"}, \"usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp\") = " + s.countCharacters(new String[]{"dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin", "ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb", "ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl", "boygirdlggnh", "xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx", "nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop", "hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx", "juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr", "lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo", "oxgaskztzroxuntiwlfyufddl", "tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp", "qnagrpfzlyrouolqquytwnwnsqnmuzphne", "eeilfdaookieawrrbvtnqfzcricvhpiv", "sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz", "yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue", "hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv", "cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo", "teyygdmmyadppuopvqdodaczob", "qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs", "qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"}, "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp"));
    }
}

class Solution {
    private final Map<Character, Integer> cnts = new HashMap<>();
    public int countCharacters(String[] words, String chars) {
        for (char c : chars.toCharArray()) {
            Integer cnt = cnts.get(c);
            if (cnt == null){
                cnt = 1;
            } else {
                cnt++;
            }
            cnts.put(c, cnt);
        }
        int result = 0;
        for (String word : words) {
            if (canForm(word)) {
                result += word.length();
            }
        }
        return result;
    }

    private boolean canForm(String word){
        Map<Character, Integer> cs = new HashMap<>(cnts);
        for (char c : word.toCharArray()) {
            Integer cnt = cs.get(c);
            if (cnt == null) {
                return false;
            }else if (cnt == 1){
                cs.remove(c);
            } else {
                cnt--;
                cs.put(c, cnt);
            }
        }
        return true;
    }
}
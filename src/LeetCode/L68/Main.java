package LeetCode.L68;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 *
 * 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 *
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 注意:
 *
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        for (String s1 : s.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16)) {
            System.out.println("\t" + s1);
        }
        System.out.println();
        for (String s1 : s.fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16)) {
            System.out.println("\t" + s1);
        }
        System.out.println();
        for (String s1 : s.fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20)) {
            System.out.println("\t" + s1);
        }
    }
}

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        // 已使用单词数
        int count = 0;
        while (count < words.length){
            // 本行已使用字母数
            int xcount = words[count].length();
            // 本行使用单词下标计数器
            int i = ++count ;
            while (i < words.length && (xcount + words[i].length()  + 1) <= maxWidth){
                xcount += (words[i].length() + 1);
                i++;
            }
            StringBuilder sb = new StringBuilder(words[count - 1]);
            // 是否为最后一行
            if (i == words.length){
                int p = count;
                while (p < words.length){
                    sb.append(" ");
                    sb.append(words[p]);
                    p++;
                }
                sb.append(" ".repeat(Math.max(0, maxWidth - sb.length())));
                result.add(sb.toString());
                break;
            } else {
                // 本行空隙数
                int wc = i - count;
                if (wc == 0){
                    sb.append(" ".repeat(maxWidth - xcount));
                    result.add(sb.toString());
                } else {
                    // 每个空隙应填最小填充空格数
                    int spx = (maxWidth - xcount) / wc + 1;
                    // 该行应填充大空格空隙数
                    int xsp = (maxWidth - xcount) % wc;
                    int p = count;
                    while (p < count + xsp){
                        sb.append(" ".repeat(Math.max(0, spx + 1)));
                        sb.append(words[p]);
                        p++;
                    }
                    while (p < i){
                        sb.append(" ".repeat(Math.max(0, spx)));
                        sb.append(words[p]);
                        p++;
                    }
                    result.add(sb.toString());
                }
                count = i;
            }
        }
        return result;
    }
}
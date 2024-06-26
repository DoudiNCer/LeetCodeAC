package LeetCode.L2671;

import java.util.HashMap;
import java.util.Map;

/**
 * 请你设计并实现一个能够对其中的值进行跟踪的数据结构，并支持对频率相关查询进行应答。
 *
 * 实现 FrequencyTracker 类：
 *
 * FrequencyTracker()：使用一个空数组初始化 FrequencyTracker 对象。
 * void add(int number)：添加一个 number 到数据结构中。
 * void deleteOne(int number)：从数据结构中删除一个 number 。数据结构 可能不包含 number ，在这种情况下不删除任何内容。
 * bool hasFrequency(int frequency): 如果数据结构中存在出现 frequency 次的数字，则返回 true，否则返回 false。
 *
 *
 * 示例 1：
 *
 * 输入
 * ["FrequencyTracker", "add", "add", "hasFrequency"]
 * [[], [3], [3], [2]]
 * 输出
 * [null, null, null, true]
 *
 * 解释
 * FrequencyTracker frequencyTracker = new FrequencyTracker();
 * frequencyTracker.add(3); // 数据结构现在包含 [3]
 * frequencyTracker.add(3); // 数据结构现在包含 [3, 3]
 * frequencyTracker.hasFrequency(2); // 返回 true ，因为 3 出现 2 次
 * 示例 2：
 *
 * 输入
 * ["FrequencyTracker", "add", "deleteOne", "hasFrequency"]
 * [[], [1], [1], [1]]
 * 输出
 * [null, null, null, false]
 *
 * 解释
 * FrequencyTracker frequencyTracker = new FrequencyTracker();
 * frequencyTracker.add(1); // 数据结构现在包含 [1]
 * frequencyTracker.deleteOne(1); // 数据结构现在为空 []
 * frequencyTracker.hasFrequency(1); // 返回 false ，因为数据结构为空
 * 示例 3：
 *
 * 输入
 * ["FrequencyTracker", "hasFrequency", "add", "hasFrequency"]
 * [[], [2], [3], [1]]
 * 输出
 * [null, false, null, true]
 *
 * 解释
 * FrequencyTracker frequencyTracker = new FrequencyTracker();
 * frequencyTracker.hasFrequency(2); // 返回 false ，因为数据结构为空
 * frequencyTracker.add(3); // 数据结构现在包含 [3]
 * frequencyTracker.hasFrequency(1); // 返回 true ，因为 3 出现 1 次
 *
 *
 * 提示：
 *
 * - 1 <= number <= 10^5
 * - 1 <= frequency <= 10^5
 * 0 最多调用 add、deleteOne 和 hasFrequency 共计 2 * 10^5 次
 */
public class Main {
    public static void main(String[] args) {
        FrequencyTracker fc = new FrequencyTracker();
        fc.add(3);
        fc.add(3);
        System.out.println("fc.hasFrequency(2) = " + fc.hasFrequency(2));
    }
}

class FrequencyTracker {

    private final Map<Integer, Integer> frequencies;

    private final Map<Integer, Integer> cFrequencies;

    public FrequencyTracker() {
        frequencies = new HashMap<>();
        cFrequencies = new HashMap<>();
    }

    public void add(int number) {
        Integer f = frequencies.get(number);
        if (f == null) {
            f = 1;
            Integer ff = cFrequencies.get(1);
            if (ff == null) {
                ff = 1;
            } else {
                ff++;
            }
            cFrequencies.put(1, ff);
        } else {
            Integer ff = cFrequencies.get(f);
            if (ff == 1) {
                cFrequencies.remove(f);
            } else if (ff > 1) {
                ff--;
                cFrequencies.put(f, ff);
            }
            f++;
            ff = cFrequencies.get(f);
            if (ff == null) {
                ff = 1;
            } else {
                ff++;
            }
            cFrequencies.put(f, ff);
        }
        frequencies.put(number, f);
    }

    public void deleteOne(int number) {
        Integer f = frequencies.get(number);
        if (f == null) {
            return;
        }
        if (f == 1) {
            frequencies.remove(number);
            Integer ff = cFrequencies.get(1);
            if (ff != null) {
                if (ff == 1) {
                    cFrequencies.remove(1);
                } else {
                    ff--;
                    cFrequencies.put(1, ff);
                }
            }
        } else {
            Integer ff = cFrequencies.get(f);
            if (ff == 1) {
                cFrequencies.remove(f);
            } else if (ff > 1) {
                ff--;
                cFrequencies.put(f, ff);
            }
            f--;
            ff = cFrequencies.get(f);
            if (ff == null) {
                ff = 1;
            } else {
                ff++;
            }
            cFrequencies.put(f, ff);
            frequencies.put(number, f);
        }

    }

    public boolean hasFrequency(int frequency) {
        return cFrequencies.get(frequency) != null;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */
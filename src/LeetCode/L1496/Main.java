package LeetCode.L1496;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
 *
 * 你从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
 *
 * 如果路径在任何位置上与自身相交，也就是走到之前已经走过的位置，请返回 true ；否则，返回 false 。
 *
 * 提示：
 *
 * 1 <= path.length <= 104
 * path[i] 为 'N'、'S'、'E' 或 'W'
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.isPathCrossing(\"NES\") = " + s.isPathCrossing("NES"));
        System.out.println("s.isPathCrossing(\"NESWW\") = " + s.isPathCrossing("NESWW"));
    }
}

class Solution {
    private int x = 0;
    private int y = 0;
    private final HashMap<Integer, HashSet<Integer>> points = new HashMap<>();
    public boolean isPathCrossing(String path) {
        HashSet<Integer> ox = new HashSet<>();
        ox.add(0);
        points.put(0, ox);
        for (char c : path.toCharArray()) {
            if (moveAndCheck(c)){
                return true;
            }
        }
        return false;
    }
    private boolean moveAndCheck(char dir){
        switch (dir) {
            case 'N' -> y++;
            case 'S' -> y--;
            case 'E' -> x--;
            case 'W' -> x++;
        }
        HashSet<Integer> ox = points.computeIfAbsent(x, k -> new HashSet<>());
        return !ox.add(y);
    }
}
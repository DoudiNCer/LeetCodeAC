package LeetCode.L874;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：
 *
 * -2 ：向左转 90 度
 * -1 ：向右转 90 度
 * 1 <= x <= 9 ：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。
 *
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，并继续执行下一个命令。
 *
 * 返回机器人距离原点的 最大欧式距离 的 平方 。（即，如果距离为 5 ，则返回 25 ）
 *
 *
 * 注意：
 *
 * 北方表示 +Y 方向。
 * 东方表示 +X 方向。
 * 南方表示 -Y 方向。
 * 西方表示 -X 方向。
 * 原点 [0,0] 可能会有障碍物。
 *
 *
 * 示例 1：
 *
 * 输入：commands = [4,-1,3], obstacles = []
 * 输出：25
 * 解释：
 * 机器人开始位于 (0, 0)：
 * 1. 向北移动 4 个单位，到达 (0, 4)
 * 2. 右转
 * 3. 向东移动 3 个单位，到达 (3, 4)
 * 距离原点最远的是 (3, 4) ，距离为 32 + 42 = 25
 * 示例 2：
 *
 * 输入：commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出：65
 * 解释：机器人开始位于 (0, 0)：
 * 1. 向北移动 4 个单位，到达 (0, 4)
 * 2. 右转
 * 3. 向东移动 1 个单位，然后被位于 (2, 4) 的障碍物阻挡，机器人停在 (1, 4)
 * 4. 左转
 * 5. 向北走 4 个单位，到达 (1, 8)
 * 距离原点最远的是 (1, 8) ，距离为 12 + 82 = 65
 * 示例 3：
 *
 * 输入：commands = [6,-1,-1,6], obstacles = []
 * 输出：36
 * 解释：机器人开始位于 (0, 0):
 * 1. 向北移动 6 个单位，到达 (0, 6).
 * 2. 右转
 * 3. 右转
 * 4. 向南移动 6 个单位，到达 (0, 0).
 * 机器人距离原点最远的点是 (0, 6)，其距离的平方是 62 = 36 个单位。
 * 提示：
 *
 * 1 <= commands.length <= 104
 * commands[i] 的值可以取 -2、-1 或者是范围 [1, 9] 内的一个整数。
 * 0 <= obstacles.length <= 10^4
 * -3 * 104 <= xi, yi <= 3 * 10^4
 * 答案保证小于 2^31
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.robotSim(new int[]{4,-1,3}, new int[][]{}) = " +
                s.robotSim(new int[]{4, -1, 3}, new int[][]{}));
    }
}

class Solution {
    private int[] f;

    private void changeCommand(int x) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int index = 0;
        for (int i = 0; i < 4; i++) {
            if (f[0] == directions[i][0] && f[1] == directions[i][1]) {
                index = i;
                break;
            }
        }

        if (x == -2) {
            index = (index + 3) % 4;  // 左转90度
        } else if (x == -1) {
            index = (index + 1) % 4;  // 右转90度
        }

        // 更新方向
        f = directions[index];
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        int px = 0, py = 0;
        f = new int[]{0, 1};
        Map<Integer, Set<Integer>> xos = new HashMap<>();
        Map<Integer, Set<Integer>> yos = new HashMap<>();
        for (int[] ob : obstacles) {
            Set<Integer> s = xos.get(ob[0]);
            if (s == null){
                s = new HashSet<>();
            }
            s.add(ob[1]);
            xos.put(ob[0], s);
            s = yos.get(ob[1]);
            if (s == null) {
                s = new HashSet<>();
            }
            s.add(ob[0]);
            yos.put(ob[1], s);
        }
        int result = 0;
        for (int cmd : commands) {
            if (cmd < 0){
                this.changeCommand(cmd);
            } else {
                if (f[0] == 0){
                    Set<Integer> ys = xos.get(px);
                    if (ys == null){
                        py += cmd * f[1];
                    } else {
                        for (int i = 0; i < cmd && !ys.contains(py + f[1]); i++){
                            py += f[1];
                        }
                    }
                } else {
                    Set<Integer> xs = yos.get(py);
                    if (xs == null){
                        px += cmd * f[0];
                    } else {
                        for (int i = 0; i < cmd && !xs.contains(px + f[0]); i++){
                            px += f[0];
                        }
                    }
                }
                result = Math.max(result, px * px + py * py);
            }
        }
        return result;
    }
}

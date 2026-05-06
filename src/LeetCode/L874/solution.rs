use super::Solution;

/*
  机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：

  -2 ：向左转 90 度
  -1 ：向右转 90 度
  1 <= x <= 9 ：向前移动 x 个单位长度
  在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。

  机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，并继续执行下一个命令。

  返回机器人距离原点的 最大欧式距离 的 平方 。（即，如果距离为 5 ，则返回 25 ）

  提示：

  1 <= commands.length <= 10^4
  commands[i] 的值可以取 -2、-1 或者是范围 [1, 9] 内的一个整数。
  0 <= obstacles.length <= 104
  -3 * 10^4 <= xi, yi <= 3 * 10^4
  答案保证小于 2^31
*/

use std::collections::HashMap;

impl Solution {
    pub fn robot_sim(commands: Vec<i32>, obstacles: Vec<Vec<i32>>) -> i32 {
        let dir_list = vec![(0, 1), (1, 0), (0, -1), (-1, 0)];
        let mut dir = 0;
        let mut px = 0;
        let mut py = 0;
        let mut res = 0;
        let mut obhx: HashMap<i32, HashMap<(i32, i32), bool>> = HashMap::new();
        let mut obhy: HashMap<i32, HashMap<(i32, i32), bool>> = HashMap::new();
        for ob in obstacles {
            let obx = ob.get(0).unwrap();
            let oby = ob.get(1).unwrap();
            obhx.entry(*obx)
                .or_insert_with(HashMap::new)
                .insert((*obx, *oby), true);
            obhy.entry(*oby)
                .or_insert_with(HashMap::new)
                .insert((*obx, *oby), true);
        }
        for x in commands {
            match x {
                -2 => {
                    dir += 3;
                    dir %= 4
                }
                -1 => {
                    dir += 1;
                    dir %= 4;
                }
                _ => {
                    let dirxy = dir_list[dir];
                    if dirxy.0 == 0 {
                        let dy = dirxy.1;
                        match obhx.get(&px) {
                            None => {
                                py += x * dy;
                            }
                            Some(obxy) => {
                                for _ in 0..x {
                                    match obxy.get(&(px, py + dy)) {
                                        None => py += dy,
                                        Some(_) => break,
                                    }
                                }
                            }
                        }
                    } else if dirxy.1 == 0 {
                        let dx = dirxy.0;
                        match obhy.get(&py) {
                            None => {
                                px += x * dx;
                            }
                            Some(obxy) => {
                                for _ in 0..x {
                                    match obxy.get(&(px + dx, py)) {
                                        None => px += dx,
                                        Some(_) => break,
                                    }
                                }
                            }
                        }
                    }
                    let mres = px * px + py * py;
                    if res < mres {
                        res = mres;
                    }
                }
            }
        }
        res
    }
}

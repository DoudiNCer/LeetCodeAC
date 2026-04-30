/*
  给你一个在 XY 平面上的 width x height 的网格图，左下角 的格子为 (0, 0) ，右上角 的格子为 (width - 1, height - 1) 。网格图中相邻格子为四个基本方向之一（"North"，"East"，"South" 和 "West"）。一个机器人 初始 在格子 (0, 0) ，方向为 "East" 。

  机器人可以根据指令移动指定的 步数 。每一步，它可以执行以下操作。

  沿着当前方向尝试 往前一步 。
  如果机器人下一步将到达的格子 超出了边界 ，机器人会 逆时针 转 90 度，然后再尝试往前一步。
  如果机器人完成了指令要求的移动步数，它将停止移动并等待下一个指令。

  请你实现 Robot 类：

  Robot(int width, int height) 初始化一个 width x height 的网格图，机器人初始在 (0, 0) ，方向朝 "East" 。
  void step(int num) 给机器人下达前进 num 步的指令。
  int[] getPos() 返回机器人当前所处的格子位置，用一个长度为 2 的数组 [x, y] 表示。
  String getDir() 返回当前机器人的朝向，为 "North" ，"East" ，"South" 或者 "West" 。

  提示：

  2 <= width, height <= 100
  1 <= num <= 10^5
  step ，getPos 和 getDir 总共 调用次数不超过 10^4 次。
*/

struct Robot {
    width: i32,
    height: i32,
    loc: i32,
    pos: Option<Vec<i32>>,
    dir: Option<String>,
}

/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl Robot {
    fn new(width: i32, height: i32) -> Self {
        Robot {
            width,
            height,
            loc: 0,
            pos: Some(vec![0, 0]),
            dir: Some(String::from("East")),
        }
    }

    fn step(&mut self, num: i32) {
        self.loc += num - 1;
        self.loc = self.loc % ((self.width + self.height - 2) << 1) + 1;
        self.pos = None;
        self.dir = None;
    }

    fn get_pos(&mut self) -> Vec<i32> {
        if let None = self.pos {
            self.i_calc();
        }
        self.pos.clone().unwrap()
    }

    fn get_dir(&mut self) -> String {
        if let None = self.dir {
            self.i_calc();
        }
        self.dir.clone().unwrap()
    }

    fn i_calc(&mut self) {
        let px: i32;
        let py: i32;
        let dir: String;
        if self.loc < self.width {
            px = self.loc;
            py = 0;
            dir = String::from("East");
        } else if self.loc < self.width + self.height - 1 {
            px = self.width - 1;
            py = self.loc - self.width + 1;
            dir = String::from("North");
        } else if self.loc < self.width + self.height + self.width - 2 {
            px = self.height + self.width + self.width - 3 - self.loc;
            py = self.height - 1;
            dir = String::from("West");
        } else {
            px = 0;
            py = ((self.width + self.height - 2) << 1) - self.loc;
            dir = String::from("South");
        }
        self.dir = Some(dir);
        self.pos = Some(vec![px, py])
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * let obj = Robot::new(width, height);
 * obj.step(num);
 * let ret_2: Vec<i32> = obj.get_pos();
 * let ret_3: String = obj.get_dir();
 */

#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let mut robot = Robot::new(6, 3);
        robot.step(2);
        robot.step(2);
        let pos = robot.get_pos();
        assert_eq!(pos, vec![4, 0]);
        let dir = robot.get_dir();
        assert_eq!(dir, "East");
        robot.step(2);
        robot.step(1);
        robot.step(4);
        let pos = robot.get_pos();
        assert_eq!(pos, vec![1, 2]);
        let dir = robot.get_dir();
        assert_eq!(dir, "West");
        robot.step(2);
        let pos = robot.get_pos();
        assert_eq!(pos, vec![0, 1]);
        let dir = robot.get_dir();
        assert_eq!(dir, "South");
    }
}

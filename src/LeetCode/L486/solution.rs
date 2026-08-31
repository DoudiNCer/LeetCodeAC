use super::Solution;

/*
    给你一个整数数组 nums 。玩家 1 和玩家 2 基于这个数组设计了一个游戏。

    玩家 1 和玩家 2 轮流进行自己的回合，玩家 1 先手。开始时，两个玩家的初始分值都是 0 。每一回合，玩家从数组的任意一端取一个数字（即，nums[0] 或 nums[nums.length - 1]），取到的数字将会从数组中移除（数组长度减 1 ）。玩家选中的数字将会加到他的得分上。当数组中没有剩余数字可取时，游戏结束。

    如果玩家 1 能成为赢家，返回 true 。如果两个玩家得分相等，同样认为玩家 1 是游戏的赢家，也返回 true 。你可以假设每个玩家的玩法都会使他的分数最大化。

    提示：

    1 <= nums.length <= 20
    0 <= nums[i] <= 10^7
*/

impl Solution {
    pub fn predict_the_winner(nums: Vec<i32>) -> bool {
        Self::dp(&nums, 0, (nums.len() - 1) as i32, true, 0)
    }
    fn dp(nums: &Vec<i32>, l: i32, r: i32, is_a: bool, diff: i32) -> bool {
        if l > r {
            return diff >= 0;
        }
        if is_a {
            Self::dp(nums, l + 1, r, false, diff + nums[l as usize])
                || Self::dp(nums, l, r - 1, false, diff + nums[r as usize])
        } else {
            Self::dp(nums, l + 1, r, true, diff - nums[l as usize])
                && Self::dp(nums, l, r - 1, true, diff - nums[r as usize])
        }
    }
}

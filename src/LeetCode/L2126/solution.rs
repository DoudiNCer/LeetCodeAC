use super::Solution;

/*
    给你一个整数 mass ，它表示一颗行星的初始质量。再给你一个整数数组 asteroids ，其中 asteroids[i] 是第 i 颗小行星的质量。

    你可以按 任意顺序 重新安排小行星的顺序，然后让行星跟它们发生碰撞。如果行星碰撞时的质量 大于等于 小行星的质量，那么小行星被 摧毁 ，并且行星会 获得 这颗小行星的质量。否则，行星将被摧毁。

    如果所有小行星 都 能被摧毁，请返回 true ，否则返回 false 。

     提示：

    1 <= mass <= 10^5
    1 <= asteroids.length <= 10^5
    1 <= asteroids[i] <= 10^5
*/

impl Solution {
    pub fn asteroids_destroyed(mass: i32, asteroids: Vec<i32>) -> bool {
        let mut mass = mass;
        let mut asteroids = asteroids;
        asteroids.sort();
        let n = asteroids.len();
        for i in 0..n {
            if mass < asteroids[i] {
                return false;
            }
            mass += asteroids[i];
            if mass >= asteroids[n - 1] {
                return true;
            }
        }
        true
    }
}

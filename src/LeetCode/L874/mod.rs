mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let commands = vec![4, -1, 3];
        let obstacles: Vec<Vec<i32>> = Vec::new();
        let result = Solution::robot_sim(commands, obstacles);
        assert_eq!(result, 25)
    }
    #[test]
    fn case2() {
        let commands = vec![4, -1, 4, -2, 4];
        let obstacles = vec![vec![2, 4]];
        let result = Solution::robot_sim(commands, obstacles);
        assert_eq!(result, 65)
    }
    #[test]
    fn case3() {
        let commands = vec![6, -1, -1, 6];
        let obstacles = vec![vec![0, 0]];
        let result = Solution::robot_sim(commands, obstacles);
        assert_eq!(result, 36)
    }
    #[test]
    fn case4() {
        let commands = vec![-2, 8, 3, 7, -1];
        let obstacles = vec![
            vec![-4, -1],
            vec![1, -1],
            vec![1, 4],
            vec![5, 0],
            vec![4, 5],
            vec![-2, -1],
            vec![2, -5],
            vec![5, 1],
            vec![-3, -1],
            vec![5, -3],
        ];
        let result = Solution::robot_sim(commands, obstacles);
        assert_eq!(result, 324)
    }
}

mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let stoneValue = vec![6, 2, 3, 4, 5, 5];
        let result = Solution::stone_game_v(stoneValue);

        assert_eq!(result, 18);
    }
    #[test]
    fn case2() {
        let stoneValue = vec![7, 7, 7, 7, 7, 7, 7];
        let result = Solution::stone_game_v(stoneValue);

        assert_eq!(result, 28);
    }
    #[test]
    fn case3() {
        let stoneValue = vec![4];
        let result = Solution::stone_game_v(stoneValue);

        assert_eq!(result, 0);
    }
}

mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let stones = vec![-1, 2, -3, 4, -5];
        let result = Solution::stone_game_viii(stones);

        assert_eq!(result, 5)
    }
    #[test]
    fn case2() {
        let stones = vec![7, -6, 5, 10, 5, -2, -6];
        let result = Solution::stone_game_viii(stones);

        assert_eq!(result, 13)
    }
    #[test]
    fn case3() {
        let stones = vec![-10, -12];
        let result = Solution::stone_game_viii(stones);

        assert_eq!(result, -22)
    }
}

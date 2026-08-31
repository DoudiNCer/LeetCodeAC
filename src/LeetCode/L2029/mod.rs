mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let stones = vec![2, 1];
        let result = Solution::stone_game_ix(stones);

        assert_eq!(result, true);
    }
    #[test]
    fn case2() {
        let stones = vec![2];
        let result = Solution::stone_game_ix(stones);

        assert_eq!(result, false);
    }
    #[test]
    fn case3() {
        let stones = vec![5, 1, 2, 4, 3];
        let result = Solution::stone_game_ix(stones);

        assert_eq!(result, false);
    }
}

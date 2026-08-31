mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let piles = vec![2, 7, 9, 4, 4];
        let result = Solution::stone_game_ii(piles);

        assert_eq!(result, 10);
    }
    #[test]
    fn case2() {
        let piles = vec![1, 2, 3, 4, 5, 100];
        let result = Solution::stone_game_ii(piles);

        assert_eq!(result, 104);
    }
}

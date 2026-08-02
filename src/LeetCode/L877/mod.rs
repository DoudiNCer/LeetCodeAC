mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let piles = vec![5, 3, 4, 5];
        let result = Solution::stone_game(piles);

        assert_eq!(result, true)
    }
    #[test]
    fn case2() {
        let piles = vec![3, 7, 2, 3];
        let result = Solution::stone_game(piles);

        assert_eq!(result, true)
    }
    #[test]
    fn case3() {
        let piles = vec![4, 2, 10, 9];
        let result = Solution::stone_game(piles);

        assert_eq!(result, true)
    }
}

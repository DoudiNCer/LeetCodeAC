mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let n = 1;
        let result = Solution::winner_square_game(n);

        assert_eq!(result, true);
    }
    #[test]
    fn case2() {
        let n = 2;
        let result = Solution::winner_square_game(n);

        assert_eq!(result, false);
    }
    #[test]
    fn case3() {
        let n = 4;
        let result = Solution::winner_square_game(n);

        assert_eq!(result, true);
    }
    #[test]
    fn case4() {
        let n = 7;
        let result = Solution::winner_square_game(n);

        assert_eq!(result, false);
    }
    #[test]
    fn case5() {
        let n = 17;
        let result = Solution::winner_square_game(n);

        assert_eq!(result, false);
    }
}

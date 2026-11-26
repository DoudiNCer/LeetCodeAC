mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let n = 12;
        let result = Solution::can_alice_win(n);

        assert_eq!(result, true);
    }
    #[test]
    fn case2() {
        let n = 1;
        let result = Solution::can_alice_win(n);

        assert_eq!(result, false);
    }
}

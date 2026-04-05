mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let moves = String::from("UD");
        let result = Solution::judge_circle(moves);
        assert!(result)
    }
    #[test]
    fn case2() {
        let moves = String::from("LL");
        let result = Solution::judge_circle(moves);
        assert!(!result)
    }
}
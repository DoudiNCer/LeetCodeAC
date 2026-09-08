mod solution;

struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let n = 1002;
        let result = Solution::count_commas(n);

        assert_eq!(result, 3);
    }
    #[test]
    fn case2() {
        let n = 998;
        let result = Solution::count_commas(n);

        assert_eq!(result, 0);
    }
}

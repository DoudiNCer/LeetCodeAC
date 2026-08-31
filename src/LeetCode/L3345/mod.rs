mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let n = 10;
        let t = 2;
        let result = Solution::smallest_number(n, t);

        assert_eq!(result, 10);
    }
    #[test]
    fn case2() {
        let n = 15;
        let t = 3;
        let result = Solution::smallest_number(n, t);

        assert_eq!(result, 16);
    }
}

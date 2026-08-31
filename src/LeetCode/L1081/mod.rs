mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = String::from("bcabc");
        let result = Solution::smallest_subsequence(s);
        let target = String::from("abc");

        assert_eq!(result, target);
    }
    #[test]
    fn case2() {
        let s = String::from("cbacdcbc");
        let result = Solution::smallest_subsequence(s);
        let target = String::from("acdb");

        assert_eq!(result, target);
    }
}

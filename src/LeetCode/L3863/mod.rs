mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = String::from("dog");
        let result = Solution::min_operations(s);

        assert_eq!(result, 1);
    }
    #[test]
    fn case2() {
        let s = String::from("card");
        let result = Solution::min_operations(s);

        assert_eq!(result, 2);
    }
    #[test]
    fn case3() {
        let s = String::from("gf");
        let result = Solution::min_operations(s);

        assert_eq!(result, -1);
    }
}

mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = String::from("abc");
        let result = Solution::reverse_degree(s);

        assert_eq!(result, 148);
    }
    #[test]
    fn case2() {
        let s = String::from("zaza");
        let result = Solution::reverse_degree(s);

        assert_eq!(result, 160);
    }
}

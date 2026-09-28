mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = String::from("(1+(2*3)+((8)/4))+1");
        let result = Solution::max_depth(s);

        assert_eq!(result, 3);
    }
    #[test]
    fn case2() {
        let s = String::from("(1)+((2))+(((3)))");
        let result = Solution::max_depth(s);

        assert_eq!(result, 3);
    }
    #[test]
    fn case3() {
        let s = String::from("()(())((()()))");
        let result = Solution::max_depth(s);

        assert_eq!(result, 3);
    }
}

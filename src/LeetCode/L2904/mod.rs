mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = String::from("100011001");
        let k = 3;
        let result = Solution::shortest_beautiful_substring(s, k);
        let target = String::from("11001");

        assert_eq!(result, target)
    }
    #[test]
    fn case2() {
        let s = String::from("1011");
        let k = 2;
        let result = Solution::shortest_beautiful_substring(s, k);
        let target = String::from("11");

        assert_eq!(result, target)
    }
    #[test]
    fn case3() {
        let s = String::from("000");
        let k = 1;
        let result = Solution::shortest_beautiful_substring(s, k);
        let target = String::from("");

        assert_eq!(result, target)
    }
}

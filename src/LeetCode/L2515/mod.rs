mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let words = vec![
            String::from("hello"),
            String::from("i"),
            String::from("am"),
            String::from("leetcode"),
            String::from("hello"),
        ];
        let target = String::from("hello");
        let startIndex = 1;
        let result = Solution::closest_target(words, target, startIndex);

        assert_eq!(result, 1);
    }
    #[test]
    fn case2() {
        let words = vec![
            String::from("a"),
            String::from("b"),
            String::from("leetcode"),
        ];
        let target = String::from("leetcode");
        let startIndex = 0;
        let result = Solution::closest_target(words, target, startIndex);

        assert_eq!(result, 1);
    }
    #[test]
    fn case3() {
        let words = vec![
            String::from("i"),
            String::from("eat"),
            String::from("leetcode"),
        ];
        let target = String::from("ate");
        let startIndex = 0;
        let result = Solution::closest_target(words, target, startIndex);

        assert_eq!(result, -1);
    }
}

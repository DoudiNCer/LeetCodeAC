mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let words = vec![
            String::from("abcw"),
            String::from("baz"),
            String::from("foo"),
            String::from("bar"),
            String::from("xtfn"),
            String::from("abcdef"),
        ];
        let result = Solution::max_product(words);

        assert_eq!(result, 16);
    }
    #[test]
    fn case2() {
        let words = vec![
            String::from("a"),
            String::from("ab"),
            String::from("abc"),
            String::from("d"),
            String::from("cd"),
            String::from("bcd"),
            String::from("abcd"),
        ];
        let result = Solution::max_product(words);

        assert_eq!(result, 4);
    }
    #[test]
    fn case3() {
        let words = vec![
            String::from("a"),
            String::from("aa"),
            String::from("aaa"),
            String::from("aaaa"),
        ];
        let result = Solution::max_product(words);

        assert_eq!(result, 0);
    }
}

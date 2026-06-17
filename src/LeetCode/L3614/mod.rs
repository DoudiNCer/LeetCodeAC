mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = String::from("a#b%*");
        let k = 1;
        let result = Solution::process_str(s, k);

        assert_eq!(result, 'a');
    }
    #[test]
    fn case2() {
        let s = String::from("cd%#*#");
        let k = 3;
        let result = Solution::process_str(s, k);

        assert_eq!(result, 'd');
    }
    #[test]
    fn case3() {
        let s = String::from("z*#");
        let k = 0;
        let result = Solution::process_str(s, k);

        assert_eq!(result, '.');
    }
}

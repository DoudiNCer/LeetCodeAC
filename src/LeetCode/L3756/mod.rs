mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = String::from("10203004");
        let queries = vec![vec![0, 7], vec![1, 3], vec![4, 6]];
        let result = Solution::sum_and_multiply(s, queries);
        let target = vec![12340, 4, 9];

        assert_eq!(result, target);
    }
    #[test]
    fn case2() {
        let s = String::from("1000");
        let queries = vec![vec![0, 3], vec![1, 1]];
        let result = Solution::sum_and_multiply(s, queries);
        let target = vec![1, 0];

        assert_eq!(result, target);
    }
    #[test]
    fn case3() {
        let s = String::from("9876543210");
        let queries = vec![vec![0, 9]];
        let result = Solution::sum_and_multiply(s, queries);
        let target = vec![444444137];

        assert_eq!(result, target);
    }
}

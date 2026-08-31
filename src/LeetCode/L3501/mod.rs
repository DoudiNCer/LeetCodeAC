mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = String::from("01");
        let queries = vec![vec![0, 1]];
        let result = Solution::max_active_sections_after_trade(s, queries);
        let target = vec![1];

        assert_eq!(result, target);
    }
    #[test]
    fn case2() {
        let s = String::from("0100");
        let queries = vec![vec![0, 3], vec![0, 2], vec![1, 3], vec![2, 3]];
        let result = Solution::max_active_sections_after_trade(s, queries);
        let target = vec![4, 3, 1, 1];

        assert_eq!(result, target);
    }
    #[test]
    fn case3() {
        let s = String::from("1000100");
        let queries = vec![vec![1, 5], vec![0, 6], vec![0, 4]];
        let result = Solution::max_active_sections_after_trade(s, queries);
        let target = vec![6, 7, 2];

        assert_eq!(result, target);
    }
    #[test]
    fn case4() {
        let s = String::from("01010");
        let queries = vec![vec![0, 3], vec![1, 4], vec![1, 3]];
        let result = Solution::max_active_sections_after_trade(s, queries);
        let target = vec![4, 4, 2];

        assert_eq!(result, target);
    }
    #[test]
    fn case5() {
        let s = String::from("10110111");
        let queries = vec![vec![3, 7], vec![4, 6], vec![0, 6]];
        let result = Solution::max_active_sections_after_trade(s, queries);
        let target = vec![6, 6, 8];

        assert_eq!(result, target);
    }
    #[test]
    fn case6() {
        let s = String::from("0011100101");
        let queries = vec![vec![7, 7], vec![5, 9], vec![8, 9], vec![7, 9]];
        let result = Solution::max_active_sections_after_trade(s, queries);
        let target = vec![5, 8, 5, 5];

        assert_eq!(result, target);
    }
}

mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 2, 3, 4, 5];
        let target = 5;
        let start = 3;
        let result = Solution::get_min_distance(nums, target, start);
        assert_eq!(result, 1)
    }
    #[test]
    fn case2() {
        let nums = vec![1];
        let target = 1;
        let start = 0;
        let result = Solution::get_min_distance(nums, target, start);
        assert_eq!(result, 0)
    }
    #[test]
    fn case3() {
        let nums = vec![1, 1, 1, 1, 1, 1, 1, 1, 1, 1];
        let target = 1;
        let start = 0;
        let result = Solution::get_min_distance(nums, target, start);
        assert_eq!(result, 0)
    }
    #[test]
    fn case4() {
        let nums = vec![5, 3, 6];
        let target = 5;
        let start = 2;
        let result = Solution::get_min_distance(nums, target, start);
        assert_eq!(result, 2)
    }
    #[test]
    fn case5() {
        let nums = vec![2202, 9326, 1034, 4180, 1932, 8118, 7365, 7738, 6220, 3440];
        let target = 3440;
        let start = 0;
        let result = Solution::get_min_distance(nums, target, start);
        assert_eq!(result, 9)
    }
    #[test]
    fn case6() {
        let nums = vec![1, 5, 3, 4, 5];
        let target = 5;
        let start = 2;
        let result = Solution::get_min_distance(nums, target, start);
        assert_eq!(result, 1)
    }
}

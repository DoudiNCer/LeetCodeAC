mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![12, 21, 45, 33, 54];
        let result = Solution::min_mirror_pair_distance(nums);
        assert_eq!(result, 1);
    }
    #[test]
    fn case2() {
        let nums = vec![120, 21];
        let result = Solution::min_mirror_pair_distance(nums);
        assert_eq!(result, 1);
    }
    #[test]
    fn case3() {
        let nums = vec![21, 120];
        let result = Solution::min_mirror_pair_distance(nums);
        assert_eq!(result, -1);
    }
}

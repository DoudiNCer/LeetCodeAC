mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![5, 0, 1, 4];
        let k = 3;
        let result = Solution::first_stable_index(nums, k);

        assert_eq!(result, 3);
    }
    #[test]
    fn case2() {
        let nums = vec![3, 2, 1];
        let k = 1;
        let result = Solution::first_stable_index(nums, k);

        assert_eq!(result, -1);
    }
    #[test]
    fn case3() {
        let nums = vec![0];
        let k = 0;
        let result = Solution::first_stable_index(nums, k);

        assert_eq!(result, 0);
    }
}

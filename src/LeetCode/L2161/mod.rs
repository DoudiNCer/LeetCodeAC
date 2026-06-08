mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![9, 12, 5, 10, 14, 3, 10];
        let pivot = 10;
        let result = Solution::pivot_array(nums, pivot);
        let target = vec![9, 5, 3, 10, 10, 12, 14];

        assert_eq!(result, target)
    }
    #[test]
    fn case2() {
        let nums = vec![-3, 4, 3, 2];
        let pivot = 2;
        let result = Solution::pivot_array(nums, pivot);
        let target = vec![-3, 2, 4, 3];

        assert_eq!(result, target)
    }
}

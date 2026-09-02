mod solution;

struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![2, 3];
        let result = Solution::uniform_array(nums);

        assert_eq!(result, true);
    }
    #[test]
    fn case2() {
        let nums = vec![4, 6];
        let result = Solution::uniform_array(nums);

        assert_eq!(result, true);
    }
}

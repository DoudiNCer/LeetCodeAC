mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![5, 4, 1, 2, 2];
        let result = Solution::maximum_length(nums);

        assert_eq!(result, 3);
    }
    #[test]
    fn case2() {
        let nums = vec![1, 3, 2, 4];
        let result = Solution::maximum_length(nums);

        assert_eq!(result, 1);
    }
    #[test]
    fn case3() {
        let nums = vec![1,1,1,1,1,1,1,1,1,1,2,4,8,16,32,64,128,256,512,1024];
        let result = Solution::maximum_length(nums);

        assert_eq!(result, 9);
    }
}

mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let arr = vec![1, 3, 5];
        let result = Solution::num_of_subarrays(arr);

        assert_eq!(result, 4);
    }
    #[test]
    fn case2() {
        let arr = vec![2, 4, 6];
        let result = Solution::num_of_subarrays(arr);

        assert_eq!(result, 0);
    }
    #[test]
    fn case3() {
        let arr = vec![1, 2, 3, 4, 5, 6, 7];
        let result = Solution::num_of_subarrays(arr);

        assert_eq!(result, 16);
    }
    #[test]
    fn case4() {
        let arr = vec![100, 100, 99, 99];
        let result = Solution::num_of_subarrays(arr);

        assert_eq!(result, 4);
    }
    #[test]
    fn case5() {
        let arr = vec![7];
        let result = Solution::num_of_subarrays(arr);

        assert_eq!(result, 1);
    }
}

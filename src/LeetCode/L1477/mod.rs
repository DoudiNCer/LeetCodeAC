mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let arr = vec![3, 2, 2, 4, 3];
        let target = 3;
        let result = Solution::min_sum_of_lengths(arr, target);

        assert_eq!(result, 2);
    }
    #[test]
    fn case2() {
        let arr = vec![7, 3, 4, 7];
        let target = 7;
        let result = Solution::min_sum_of_lengths(arr, target);

        assert_eq!(result, 2);
    }
    #[test]
    fn case3() {
        let arr = vec![4, 3, 2, 6, 2, 3, 4];
        let target = 6;
        let result = Solution::min_sum_of_lengths(arr, target);

        assert_eq!(result, -1);
    }
    #[test]
    fn case4() {
        let arr = vec![5, 5, 4, 4, 5];
        let target = 3;
        let result = Solution::min_sum_of_lengths(arr, target);

        assert_eq!(result, -1);
    }
    #[test]
    fn case5() {
        let arr = vec![3, 1, 1, 1, 5, 1, 2, 1];
        let target = 3;
        let result = Solution::min_sum_of_lengths(arr, target);

        assert_eq!(result, 3);
    }
}

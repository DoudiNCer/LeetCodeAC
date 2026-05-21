mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let arr1 = vec![1, 10, 100];
        let arr2 = vec![1000];
        let result = Solution::longest_common_prefix(arr1, arr2);

        assert_eq!(result, 3);
    }
    #[test]
    fn case2() {
        let arr1 = vec![1, 2, 3];
        let arr2 = vec![4, 4, 4];
        let result = Solution::longest_common_prefix(arr1, arr2);

        assert_eq!(result, 0);
    }
}

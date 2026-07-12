mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let arr = vec![40, 10, 20, 30];
        let result = Solution::array_rank_transform(arr);
        let target = vec![4, 1, 2, 3];

        assert_eq!(result, target);
    }
    #[test]
    fn case2() {
        let arr = vec![100, 100, 100];
        let result = Solution::array_rank_transform(arr);
        let target = vec![1, 1, 1];

        assert_eq!(result, target);
    }
}

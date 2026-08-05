mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let n = 4;
        let k = 1;
        let invocations = vec![vec![1, 2], vec![0, 1], vec![3, 2]];
        let result = Solution::remaining_methods(n, k, invocations);
        let target = vec![0, 1, 2, 3];

        assert_eq!(result, target);
    }
    #[test]
    fn case2() {
        let n = 5;
        let k = 0;
        let invocations = vec![vec![1, 2], vec![0, 2], vec![0, 1], vec![3, 4]];
        let result = Solution::remaining_methods(n, k, invocations);
        let target = vec![3, 4];

        assert_eq!(result, target);
    }
    #[test]
    fn case3() {
        let n = 3;
        let k = 2;
        let invocations = vec![vec![1, 2], vec![0, 1], vec![2, 0]];
        let result = Solution::remaining_methods(n, k, invocations);
        let target = vec![];

        assert_eq!(result, target);
    }
}

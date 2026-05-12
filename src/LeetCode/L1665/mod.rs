mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let tasks = vec![vec![1, 2], vec![2, 4], vec![4, 8]];
        let result = Solution::minimum_effort(tasks);

        assert_eq!(result, 8);
    }
    #[test]
    fn case2() {
        let tasks = vec![
            vec![1, 3],
            vec![2, 4],
            vec![10, 11],
            vec![10, 12],
            vec![8, 9],
        ];
        let result = Solution::minimum_effort(tasks);

        assert_eq!(result, 32);
    }
    #[test]
    fn case3() {
        let tasks = vec![
            vec![1, 7],
            vec![2, 8],
            vec![3, 9],
            vec![4, 10],
            vec![5, 11],
            vec![6, 12],
        ];
        let result = Solution::minimum_effort(tasks);

        assert_eq!(result, 27);
    }
}

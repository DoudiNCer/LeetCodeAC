mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let intervals = vec![
            vec![1, 3, 2],
            vec![4, 5, 2],
            vec![1, 5, 5],
            vec![6, 9, 3],
            vec![6, 7, 1],
            vec![8, 9, 1],
        ];
        let result = Solution::maximum_weight(intervals);
        let target = vec![2, 3];

        assert_eq!(result, target);
    }
    #[test]
    fn case2() {
        let intervals = vec![
            vec![5, 8, 1],
            vec![6, 7, 7],
            vec![4, 7, 3],
            vec![9, 10, 6],
            vec![7, 8, 2],
            vec![11, 14, 3],
            vec![3, 5, 5],
        ];
        let result = Solution::maximum_weight(intervals);
        let target = vec![1, 3, 5, 6];

        assert_eq!(result, target);
    }
}

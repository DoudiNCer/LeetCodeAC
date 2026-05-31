mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let A = vec![1, 3, 2, 4];
        let B = vec![3, 1, 2, 4];
        let result = Solution::find_the_prefix_common_array(A, B);

        assert_eq!(result, vec![0, 2, 3, 4]);
    }
    #[test]
    fn case2() {
        let A = vec![2, 3, 1];
        let B = vec![3, 1, 2];
        let result = Solution::find_the_prefix_common_array(A, B);

        assert_eq!(result, vec![0, 1, 3]);
    }
}

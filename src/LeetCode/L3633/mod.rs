mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let landStartTime = vec![2, 8];
        let landDuration = vec![4, 1];
        let waterStartTime = vec![6];
        let waterDuration = vec![3];
        let result = Solution::earliest_finish_time(
            landStartTime,
            landDuration,
            waterStartTime,
            waterDuration,
        );

        assert_eq!(result, 9);
    }
    #[test]
    fn case2() {
        let landStartTime = vec![5];
        let landDuration = vec![3];
        let waterStartTime = vec![1];
        let waterDuration = vec![10];
        let result = Solution::earliest_finish_time(
            landStartTime,
            landDuration,
            waterStartTime,
            waterDuration,
        );

        assert_eq!(result, 14);
    }
}

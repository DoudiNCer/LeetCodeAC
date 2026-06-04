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
    #[test]
    fn case3() {
        let landStartTime = vec![82, 14];
        let landDuration = vec![42, 30];
        let waterStartTime = vec![6, 54];
        let waterDuration = vec![91, 71];
        let result = Solution::earliest_finish_time(
            landStartTime,
            landDuration,
            waterStartTime,
            waterDuration,
        );

        assert_eq!(result, 125);
    }
    #[test]
    fn case4() {
        let landStartTime = vec![41, 59, 14];
        let landDuration = vec![8, 74, 45];
        let waterStartTime = vec![41, 78];
        let waterDuration = vec![16, 33];
        let result = Solution::earliest_finish_time(
            landStartTime,
            landDuration,
            waterStartTime,
            waterDuration,
        );

        assert_eq!(result, 65);
    }
    #[test]
    fn case45() {
        let landStartTime = vec![10, 19, 36, 31, 28, 94];
        let landDuration = vec![42, 39, 64, 32, 60, 91];
        let waterStartTime = vec![14, 85, 54, 69, 61, 100];
        let waterDuration = vec![52, 43, 82, 47, 66, 22];
        let result = Solution::earliest_finish_time(
            landStartTime,
            landDuration,
            waterStartTime,
            waterDuration,
        );

        assert_eq!(result, 98);
    }
}

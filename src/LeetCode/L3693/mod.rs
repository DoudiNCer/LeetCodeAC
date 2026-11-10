mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let n = 4;
        let costs = vec![1, 2, 3, 4];
        let result = Solution::climb_stairs(n, costs);

        assert_eq!(result, 13);
    }
    #[test]
    fn case2() {
        let n = 4;
        let costs = vec![5, 1, 6, 2];
        let result = Solution::climb_stairs(n, costs);

        assert_eq!(result, 11);
    }
    #[test]
    fn case3() {
        let n = 3;
        let costs = vec![9, 8, 3];
        let result = Solution::climb_stairs(n, costs);

        assert_eq!(result, 12);
    }
}

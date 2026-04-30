mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let colors = vec![1, 1, 1, 6, 1, 1, 1];
        let result = Solution::max_distance(colors);
        assert_eq!(result, 3)
    }
    #[test]
    fn case2() {
        let colors = vec![1, 8, 3, 8, 3];
        let result = Solution::max_distance(colors);
        assert_eq!(result, 4)
    }
    #[test]
    fn case3() {
        let colors = vec![0, 1];
        let result = Solution::max_distance(colors);
        assert_eq!(result, 1)
    }
    #[test]
    fn case4() {
        let colors = vec![4, 4, 4, 11, 4, 4, 11, 4, 4, 4, 4, 4];
        let result = Solution::max_distance(colors);
        assert_eq!(result, 8)
    }
}

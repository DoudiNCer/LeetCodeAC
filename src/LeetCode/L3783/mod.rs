mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let n = 25;
        let result = Solution::mirror_distance(n);
        assert_eq!(result, 27);
    }
    #[test]
    fn case2() {
        let n = 10;
        let result = Solution::mirror_distance(n);
        assert_eq!(result, 9);
    }
    #[test]
    fn case3() {
        let n = 7;
        let result = Solution::mirror_distance(n);
        assert_eq!(result, 0);
    }
}
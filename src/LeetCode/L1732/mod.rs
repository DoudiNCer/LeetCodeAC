mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let gein = vec![-5, 1, 5, 0, -7];
        let result = Solution::largest_altitude(gein);

        assert_eq!(result, 1)
    }
    #[test]
    fn case2() {
        let gein = vec![-4, -3, -2, -1, 4, 3, 2];
        let result = Solution::largest_altitude(gein);

        assert_eq!(result, 0)
    }
}

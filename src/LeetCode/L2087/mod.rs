mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let startPos = vec![1, 0];
        let homePos = vec![2, 3];
        let rowCosts = vec![5, 4, 3];
        let colCosts = vec![8, 2, 6, 7];
        let result = Solution::min_cost(startPos, homePos, rowCosts, colCosts);
        assert_eq!(result, 18)
    }
    #[test]
    fn case2() {
        let startPos = vec![0, 0];
        let homePos = vec![0, 0];
        let rowCosts = vec![5];
        let colCosts = vec![26];
        let result = Solution::min_cost(startPos, homePos, rowCosts, colCosts);
        assert_eq!(result, 0)
    }
}

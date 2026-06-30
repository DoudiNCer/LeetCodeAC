mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let costs = vec![1, 3, 2, 4, 1];
        let coins = 7;
        let result = Solution::max_ice_cream(costs, coins);

        assert_eq!(result, 4)
    }
    #[test]
    fn case2() {
        let costs = vec![10, 6, 8, 7, 7, 8];
        let coins = 5;
        let result = Solution::max_ice_cream(costs, coins);

        assert_eq!(result, 0)
    }
    #[test]
    fn case3() {
        let costs = vec![1, 6, 3, 1, 2, 5];
        let coins = 20;
        let result = Solution::max_ice_cream(costs, coins);

        assert_eq!(result, 6)
    }
}

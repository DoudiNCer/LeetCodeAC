mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let cost1 = 3;
        let cost2 = 2;
        let costBoth = 1;
        let need1 = 3;
        let need2 = 2;
        let result = Solution::minimum_cost(cost1, cost2, costBoth, need1, need2);

        assert_eq!(result, 3);
    }
    #[test]
    fn case2() {
        let cost1 = 5;
        let cost2 = 4;
        let costBoth = 15;
        let need1 = 2;
        let need2 = 3;
        let result = Solution::minimum_cost(cost1, cost2, costBoth, need1, need2);

        assert_eq!(result, 22);
    }
    #[test]
    fn case3() {
        let cost1 = 5;
        let cost2 = 4;
        let costBoth = 15;
        let need1 = 0;
        let need2 = 0;
        let result = Solution::minimum_cost(cost1, cost2, costBoth, need1, need2);

        assert_eq!(result, 0);
    }
}

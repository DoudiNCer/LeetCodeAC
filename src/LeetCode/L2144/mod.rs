mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let cost = vec![1, 2, 3];
        let result = Solution::minimum_cost(cost);

        assert_eq!(result, 5)
    }
    #[test]
    fn case2() {
        let cost = vec![6, 5, 7, 9, 2, 2];
        let result = Solution::minimum_cost(cost);

        assert_eq!(result, 23)
    }
    #[test]
    fn case3() {
        let cost = vec![5, 5];
        let result = Solution::minimum_cost(cost);

        assert_eq!(result, 10)
    }
}

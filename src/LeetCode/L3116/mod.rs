mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let coins = vec![3, 6, 9];
        let k = 3;
        let result = Solution::find_kth_smallest(coins, k);

        assert_eq!(result, 9);
    }
    #[test]
    fn case2() {
        let coins = vec![5, 2];
        let k = 7;
        let result = Solution::find_kth_smallest(coins, k);

        assert_eq!(result, 12);
    }
}

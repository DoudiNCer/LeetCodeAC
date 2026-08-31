mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let n = 4;
        let result = Solution::gcd_of_odd_even_sums(n);
        
        assert_eq!(result, 4);
    }
    #[test]
    fn case2() {
        let n = 5;
        let result = Solution::gcd_of_odd_even_sums(n);

        assert_eq!(result, 5);
    }
}

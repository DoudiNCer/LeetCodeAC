mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
       let word = String::from("CAKE");
        let result = Solution::minimum_distance(word);

        assert_eq!(result, 3);
    }
    #[test]
    fn case2() {
        let word = String::from("HAPPY");
        let result = Solution::minimum_distance(word);

        assert_eq!(result, 6);
    }
}
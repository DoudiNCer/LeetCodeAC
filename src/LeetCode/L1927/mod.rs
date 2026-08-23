mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let num = String::from("5023");
        let result = Solution::sum_game(num);
        
        assert_eq!(result, false);
    }
    #[test]
    fn case2() {
        let num = String::from("25??");
        let result = Solution::sum_game(num);

        assert_eq!(result, true);
    }
    #[test]
    fn case3() {
        let num = String::from("?3295???");
        let result = Solution::sum_game(num);

        assert_eq!(result, false);
    }
}

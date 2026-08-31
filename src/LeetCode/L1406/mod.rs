mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let values = vec![1, 2, 3, 7];
        let result = Solution::stone_game_iii(values);
        let target = String::from("Bob");

        assert_eq!(result, target);
    }
    #[test]
    fn case2() {
        let values = vec![1, 2, 3, -9];
        let result = Solution::stone_game_iii(values);
        let target = String::from("Alice");

        assert_eq!(result, target);
    }
    #[test]
    fn case3() {
        let values = vec![1, 2, 3, 6];
        let result = Solution::stone_game_iii(values);
        let target = String::from("Tie");

        assert_eq!(result, target);
    }
}

mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let moves = String::from("L_RL__R");
        let result = Solution::furthest_distance_from_origin(moves);

        assert_eq!(result, 3);
    }
    #[test]
    fn case2() {
        let moves = String::from("_R__LL_");
        let result = Solution::furthest_distance_from_origin(moves);

        assert_eq!(result, 5);
    }
    #[test]
    fn case3() {
        let moves = String::from("_______");
        let result = Solution::furthest_distance_from_origin(moves);

        assert_eq!(result, 7);
    }
}

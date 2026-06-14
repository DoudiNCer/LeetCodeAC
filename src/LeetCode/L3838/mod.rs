mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let words = vec![
            String::from("abcd"),
            String::from("def"),
            String::from("xyz"),
        ];
        let weights = vec![
            5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2,
        ];
        let result = Solution::map_word_weights(words, weights);

        assert_eq!(result, String::from("rij"));
    }
    #[test]
    fn case2() {
        let words = vec![String::from("a"), String::from("b"), String::from("c")];
        let weights = vec![
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
        ];
        let result = Solution::map_word_weights(words, weights);

        assert_eq!(result, String::from("yyy"));
    }
}

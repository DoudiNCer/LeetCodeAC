mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let queries = vec![
            String::from("word"),
            String::from("note"),
            String::from("ants"),
            String::from("wood"),
        ];
        let dictionary = vec![
            String::from("wood"),
            String::from("joke"),
            String::from("moat"),
        ];
        let result = Solution::two_edit_words(queries, dictionary);

        assert_eq!(
            result,
            vec![
                String::from("word"),
                String::from("note"),
                String::from("wood")
            ]
        );
    }
    #[test]
    fn case2() {
        let queries = vec![String::from("yes")];
        let dictionary = vec![String::from("not")];
        let result = Solution::two_edit_words(queries, dictionary);

        assert_eq!(result, Vec::<String>::new());
    }
}

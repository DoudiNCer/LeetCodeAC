mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = String::from("(name)is(age)yearsold");
        let knowledge = vec![
            vec!["name".to_string(), "bob".to_string()],
            vec!["age".to_string(), "two".to_string()],
        ];
        let result = Solution::evaluate(s, knowledge);
        let target = String::from("bobistwoyearsold");

        assert_eq!(result, target)
    }
    #[test]
    fn case2() {
        let s = String::from("hi(name)");
        let knowledge = vec![vec!["a".to_string(), "b".to_string()]];
        let result = Solution::evaluate(s, knowledge);
        let target = String::from("hi?");

        assert_eq!(result, target)
    }
    #[test]
    fn case3() {
        let s = String::from("(a)(a)(a)aaa");
        let knowledge = vec![vec!["a".to_string(), "yes".to_string()]];
        let result = Solution::evaluate(s, knowledge);
        let target = String::from("yesyesyesaaa");

        assert_eq!(result, target)
    }
}

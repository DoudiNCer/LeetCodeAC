mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let edges = vec![vec![0, 1, 5], vec![1, 3, 10], vec![0, 2, 3], vec![2, 3, 4]];
        let online = vec![true, true, true, true];
        let k = 10;
        let result = Solution::find_max_path_score(edges, online, k);

        assert_eq!(result, 3);
    }
    #[test]
    fn case2() {
        let edges = vec![
            vec![0, 1, 7],
            vec![1, 4, 5],
            vec![0, 2, 6],
            vec![2, 3, 6],
            vec![3, 4, 2],
            vec![2, 4, 6],
        ];
        let online = vec![true, true, true, false, true];
        let k = 12;
        let result = Solution::find_max_path_score(edges, online, k);

        assert_eq!(result, 6);
    }
    #[test]
    fn case3() {
        let edges = vec![];
        let online = vec![true, true];
        let k = 73;
        let result = Solution::find_max_path_score(edges, online, k);

        assert_eq!(result, -1);
    }
}

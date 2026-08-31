mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let n = 3;
        let reservedSeats = vec![
            vec![1, 2],
            vec![1, 3],
            vec![1, 8],
            vec![2, 6],
            vec![3, 1],
            vec![3, 10],
        ];
        let result = Solution::max_number_of_families(n, reservedSeats);

        assert_eq!(result, 4);
    }
    #[test]
    fn case2() {
        let n = 2;
        let reservedSeats = vec![vec![2, 1], vec![1, 8], vec![2, 6]];
        let result = Solution::max_number_of_families(n, reservedSeats);

        assert_eq!(result, 2);
    }
    #[test]
    fn case3() {
        let n = 4;
        let reservedSeats = vec![vec![4, 3], vec![1, 4], vec![4, 6], vec![1, 7]];
        let result = Solution::max_number_of_families(n, reservedSeats);

        assert_eq!(result, 4);
    }
}

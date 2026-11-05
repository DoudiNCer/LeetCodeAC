mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let arr1 = vec![4, 5, 8];
        let arr2 = vec![10, 9, 1, 8];
        let d = 2;
        let result = Solution::find_the_distance_value(arr1, arr2, d);

        assert_eq!(result, 2);
    }
    #[test]
    fn case2() {
        let arr1 = vec![1, 4, 2, 3];
        let arr2 = vec![-4, -3, 6, 10, 20, 30];
        let d = 3;
        let result = Solution::find_the_distance_value(arr1, arr2, d);

        assert_eq!(result, 2);
    }
    #[test]
    fn case3() {
        let arr1 = vec![2, 1, 100, 3];
        let arr2 = vec![-5, -2, 10, -3, 7];
        let d = 6;
        let result = Solution::find_the_distance_value(arr1, arr2, d);

        assert_eq!(result, 1);
    }
}

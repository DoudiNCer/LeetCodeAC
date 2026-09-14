mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let rec1 = vec![0,0,2,2];
        let rec2 = vec![1,1,3,3];
        let result = Solution::is_rectangle_overlap(rec1, rec2);

        assert_eq!(result, true)
    }
    #[test]
    fn case2() {
        let rec1 = vec![0,0,1,1];
        let rec2 = vec![1,0,2,1];
        let result = Solution::is_rectangle_overlap(rec1, rec2);

        assert_eq!(result, false)
    }
    #[test]
    fn case3() {
        let rec1 = vec![0,0,1,1];
        let rec2 = vec![2,2,3,3];
        let result = Solution::is_rectangle_overlap(rec1, rec2);

        assert_eq!(result, false)
    }
}

mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums1 = vec![55, 30, 5, 4, 2];
        let nums2 = vec![100, 20, 10, 10, 5];
        let result = Solution::max_distance(Vec::from(nums1), nums2);
        assert_eq!(result, 2)
    }
    #[test]
    fn case2() {
        let nums1 = vec![1, 1, 2];
        let nums2 = vec![10, 10, 1];
        let result = Solution::max_distance(Vec::from(nums1), nums2);
        assert_eq!(result, 1)
    }
    #[test]
    fn case3() {
        let nums1 = vec![30, 29, 19, 5];
        let nums2 = vec![25, 25, 25, 25, 25];
        let result = Solution::max_distance(Vec::from(nums1), nums2);
        assert_eq!(result, 2)
    }
}

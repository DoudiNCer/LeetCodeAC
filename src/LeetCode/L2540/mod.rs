mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums1 = vec![1, 2, 3];
        let nums2 = vec![2, 4];
        let result = Solution::get_common(nums1, nums2);

        assert_eq!(result, 2);
    }
    #[test]
    fn case2() {
        let nums1 = vec![1, 2, 3, 6];
        let nums2 = vec![2, 3, 4, 5];
        let result = Solution::get_common(nums1, nums2);

        assert_eq!(result, 2);
    }
}

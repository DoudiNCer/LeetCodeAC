mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let n = 3;
        let l = 4;
        let r = 5;
        let result = Solution::zig_zag_arrays(n, l, r);

        assert_eq!(result, 2);
    }
    #[test]
    fn case2() {
        let n = 3;
        let l = 1;
        let r = 3;
        let result = Solution::zig_zag_arrays(n, l, r);

        assert_eq!(result, 10);
    }
    #[test]
    fn case3() {
        let n = 7;
        let l = 8;
        let r = 45;
        let result = Solution::zig_zag_arrays(n, l, r);

        assert_eq!(result, 257729443);
    }
}

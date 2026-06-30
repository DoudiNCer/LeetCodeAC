mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let (hour, minute) = (12, 30);
        let result = Solution::angle_clock(hour, minute);

        assert_eq!(result, 165f64);
    }
    #[test]
    fn case2() {
        let (hour, minute) = (3, 30);
        let result = Solution::angle_clock(hour, minute);

        assert_eq!(result, 75f64);
    }
    #[test]
    fn case3() {
        let (hour, minute) = (3, 15);
        let result = Solution::angle_clock(hour, minute);

        assert_eq!(result, 7.5f64);
    }
    #[test]
    fn case4() {
        let (hour, minute) = (4, 50);
        let result = Solution::angle_clock(hour, minute);

        assert_eq!(result, 155f64);
    }
    #[test]
    fn case5() {
        let (hour, minute) = (12, 0);
        let result = Solution::angle_clock(hour, minute);

        assert_eq!(result, 0f64);
    }
}

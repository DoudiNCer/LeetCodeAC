mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let arriveAlice = "08-15".to_string();
        let leaveAlice = "08-18".to_string();
        let arriveBob = "08-16".to_string();
        let leaveBob = "08-19".to_string();
        let result = Solution::count_days_together(arriveAlice, leaveAlice, arriveBob, leaveBob);

        assert_eq!(result, 3);
    }
    #[test]
    fn case2() {
        let arriveAlice = "10-01".to_string();
        let leaveAlice = "10-31".to_string();
        let arriveBob = "11-01".to_string();
        let leaveBob = "12-31".to_string();
        let result = Solution::count_days_together(arriveAlice, leaveAlice, arriveBob, leaveBob);

        assert_eq!(result, 0);
    }
}

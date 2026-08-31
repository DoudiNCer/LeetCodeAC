mod listnode;
mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let head = listnode::ListNode::from_vec(vec![3, 1]);
        let result = Solution::nodes_between_critical_points(head);
        let target = vec![-1, -1];

        assert_eq!(result, target);
    }
    #[test]
    fn case2() {
        let head = listnode::ListNode::from_vec(vec![5, 3, 1, 2, 5, 1, 2]);
        let result = Solution::nodes_between_critical_points(head);
        let target = vec![1, 3];

        assert_eq!(result, target);
    }
    #[test]
    fn case3() {
        let head = listnode::ListNode::from_vec(vec![1, 3, 2, 2, 3, 2, 2, 2, 7]);
        let result = Solution::nodes_between_critical_points(head);
        let target = vec![3, 3];

        assert_eq!(result, target);
    }
    #[test]
    fn case4() {
        let head = listnode::ListNode::from_vec(vec![2, 3, 3, 2]);
        let result = Solution::nodes_between_critical_points(head);
        let target = vec![-1, -1];

        assert_eq!(result, target);
    }
}

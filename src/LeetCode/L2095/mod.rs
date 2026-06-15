mod listnode;
mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let head = listnode::ListNode::from_vec(vec![1, 3, 4, 7, 1, 2, 6]);
        let result = Solution::delete_middle(head);
        let target = listnode::ListNode::from_vec(vec![1, 3, 4, 1, 2, 6]);

        assert_eq!(result, target)
    }
    #[test]
    fn case2() {
        let head = listnode::ListNode::from_vec(vec![1, 2, 3, 4]);
        let result = Solution::delete_middle(head);
        let target = listnode::ListNode::from_vec(vec![1, 2, 4]);

        assert_eq!(result, target)
    }
    #[test]
    fn case3() {
        let head = listnode::ListNode::from_vec(vec![2, 1]);
        let result = Solution::delete_middle(head);
        let target = listnode::ListNode::from_vec(vec![2]);

        assert_eq!(result, target)
    }
}

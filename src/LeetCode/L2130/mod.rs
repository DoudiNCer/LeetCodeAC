mod listnode;
mod solution;

struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    use std::collections::LinkedList;
    #[test]
    fn case1() {
        let head = listnode::ListNode::from_vec(vec![5, 4, 2, 1]);
        let result = Solution::pair_sum(head);

        assert_eq!(result, 6)
    }
    #[test]
    fn case2() {
        let head = listnode::ListNode::from_vec(vec![4, 2, 2, 3]);
        let result = Solution::pair_sum(head);

        assert_eq!(result, 7)
    }
    #[test]
    fn case3() {
        let head = listnode::ListNode::from_vec(vec![1, 100000]);
        let result = Solution::pair_sum(head);

        assert_eq!(result, 100001)
    }
}

mod solution;
mod treenode;

struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    use std::cell::RefCell;
    use std::rc::Rc;
    #[test]
    fn case1() {
        let root = Some(Rc::new(RefCell::new(treenode::TreeNode {
            val: 4,
            left: Some(Rc::new(RefCell::new(treenode::TreeNode {
                val: 8,
                left: Some(Rc::new(RefCell::new(treenode::TreeNode {
                    val: 0,
                    left: None,
                    right: None,
                }))),
                right: Some(Rc::new(RefCell::new(treenode::TreeNode {
                    val: 1,
                    left: None,
                    right: None,
                }))),
            }))),
            right: Some(Rc::new(RefCell::new(treenode::TreeNode {
                val: 5,
                left: None,
                right: Some(Rc::new(RefCell::new(treenode::TreeNode {
                    val: 6,
                    left: None,
                    right: None,
                }))),
            }))),
        })));
        let result = Solution::average_of_subtree(root);

        assert_eq!(result, 5)
    }
    #[test]
    fn case2() {
        let root = Some(Rc::new(RefCell::new(treenode::TreeNode {
            val: 1,
            left: None,
            right: None,
        })));
        let result = Solution::average_of_subtree(root);

        assert_eq!(result, 1)
    }
}

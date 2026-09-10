use super::Solution;
use super::treenode::TreeNode;
/*
    给你一棵二叉树的根节点 root ，找出并返回满足要求的节点数，要求节点的值等于其 子树 中值的 平均值 。

    注意：

    n 个元素的平均值可以由 n 个元素 求和 然后再除以 n ，并 向下舍入 到最近的整数。
    root 的 子树 由 root 和它的所有后代组成。

    提示：

    树中节点数目在范围 [1, 1000] 内
    0 <= Node.val <= 1000
*/

// Definition for a binary tree node.
// #[derive(Debug, PartialEq, Eq)]
// pub struct TreeNode {
//   pub val: i32,
//   pub left: Option<Rc<RefCell<TreeNode>>>,
//   pub right: Option<Rc<RefCell<TreeNode>>>,
// }
//
// impl TreeNode {
//   #[inline]
//   pub fn new(val: i32) -> Self {
//     TreeNode {
//       val,
//       left: None,
//       right: None
//     }
//   }
// }

use std::cell::RefCell;
use std::rc::Rc;

impl Solution {
    pub fn average_of_subtree(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        let mut ans = 0;
        Self::dfs_sum(&root, &mut ans);
        ans
    }

    fn dfs_sum(root: &Option<Rc<RefCell<TreeNode>>>, ans: &mut i32) -> (i32, i32) {
        if let Some(node) = root {
            let node = node.borrow();
            let (lc, ls) = Self::dfs_sum(&node.left, ans);
            let (rc, rs) = Self::dfs_sum(&node.right, ans);
            let (cnt, sum) = (lc + rc + 1, ls + rs + node.val);
            if cnt == 0 || sum / cnt == node.val {
                *ans += 1;
            }
            return (cnt, sum);
        }
        (0, 0)
    }
}

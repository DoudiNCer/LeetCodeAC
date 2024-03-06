package LeetCode.L1361;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * 二叉树上有 n 个节点，按从 0 到 n - 1 编号，其中节点 i 的两个子节点分别是 leftChild[i] 和 rightChild[i]。
 *
 * 只有 所有 节点能够形成且 只 形成 一颗 有效的二叉树时，返回 true；否则返回 false。
 *
 * 如果节点 i 没有左子节点，那么 leftChild[i] 就等于 -1。右子节点也符合该规则。
 *
 * 注意：节点没有值，本问题中仅仅使用节点编号。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
 * 输出：true
 * 示例 2：
 *
 *
 *
 * 输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
 * 输出：false
 * 示例 3：
 *
 *
 *
 * 输入：n = 2, leftChild = [1,0], rightChild = [-1,-1]
 * 输出：false
 * 示例 4：
 *
 *
 *
 * 输入：n = 6, leftChild = [1,-1,-1,4,-1,-1], rightChild = [2,-1,-1,5,-1,-1]
 * 输出：false
 *
 *
 * 提示：
 *
 * - 1 <= n <= 10^4
 * - leftChild.length == rightChild.length == n
 * - -1 <= leftChild[i], rightChild[i] <= n - 1
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, -1, -1, -1}) = " + s.validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, -1, -1, -1}));
        System.out.println("s.validateBinaryTreeNodes(4, new int[]{1, 0, 3, -1}, new int[]{-1, -1, -1, -1}) = " + s.validateBinaryTreeNodes(4, new int[]{1, 0, 3, -1}, new int[]{-1, -1, -1, -1}));
        System.out.println("s.validateBinaryTreeNodes(4, new int[]{3, -1, 1, -1}, new int[]{-1, -1, 0, -1}) = " + s.validateBinaryTreeNodes(4, new int[]{3, -1, 1, -1}, new int[]{-1, -1, 0, -1}));
    }
}

class Solution {
    private int[] lc;
    private int[] rc;
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parents = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++){
            if (leftChild[i] != -1){
                if (parents[leftChild[i]] == 0){
                    parents[leftChild[i]] = i + 1;
                    cnt++;
                } else {
                    return false;
                }
            }
            if (rightChild[i] != -1){
                if (parents[rightChild[i]] == 0){
                    parents[rightChild[i]] = i + 1;
                    cnt++;
                } else {
                    return false;
                }
            }
        }
        System.out.println("parents = " + Arrays.toString(parents));
        if (n != cnt + 1){
            return false;
        }
        int root = -1;
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == 0){
                root = i;
                break;
            }
        }
        lc = leftChild;
        rc = rightChild;
        return countTheTree(root) == n;
    }

    private int countTheTree(int root){
        if (root == -1){
            return 0;
        }
        return 1 + countTheTree(lc[root]) + countTheTree(rc[root]);
    }
}
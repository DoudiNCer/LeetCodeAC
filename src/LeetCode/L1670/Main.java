package LeetCode.L1670;

import java.util.LinkedList;

/**
 * 请你设计一个队列，支持在前，中，后三个位置的 push 和 pop 操作。
 *
 * 请你完成 FrontMiddleBack 类：
 *
 * FrontMiddleBack() 初始化队列。
 * void pushFront(int val) 将 val 添加到队列的 最前面 。
 * void pushMiddle(int val) 将 val 添加到队列的 正中间 。
 * void pushBack(int val) 将 val 添加到队里的 最后面 。
 * int popFront() 将 最前面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * int popMiddle() 将 正中间 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * int popBack() 将 最后面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * 请注意当有 两个 中间位置的时候，选择靠前面的位置进行操作。比方说：
 *
 * 将 6 添加到 [1, 2, 3, 4, 5] 的中间位置，结果数组为 [1, 2, 6, 3, 4, 5] 。
 * 从 [1, 2, 3, 4, 5, 6] 的中间位置弹出元素，返回 3 ，数组变为 [1, 2, 4, 5, 6] 。
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle", "popFront", "popMiddle", "popMiddle", "popBack", "popFront"]
 * [[], [1], [2], [3], [4], [], [], [], [], []]
 * 输出：
 * [null, null, null, null, null, 1, 3, 4, 2, -1]
 *
 * 解释：
 * FrontMiddleBackQueue q = new FrontMiddleBackQueue();
 * q.pushFront(1);   // [1]
 * q.pushBack(2);    // [1, 2]
 * q.pushMiddle(3);  // [1, 3, 2]
 * q.pushMiddle(4);  // [1, 4, 3, 2]
 * q.popFront();     // 返回 1 -> [4, 3, 2]
 * q.popMiddle();    // 返回 3 -> [4, 2]
 * q.popMiddle();    // 返回 4 -> [2]
 * q.popBack();      // 返回 2 -> []
 * q.popFront();     // 返回 -1 -> [] （队列为空）
 *
 *
 * 提示：
 *
 * - 1 <= val <= 10^9
 * - 最多调用 1000 次 pushFront， pushMiddle， pushBack， popFront， popMiddle 和 popBack 。
 */
public class Main {
    public static void main(String[] args) {
        FrontMiddleBackQueue queue = new FrontMiddleBackQueue();
        queue.pushFront(1);
        queue.pushBack(2);
        queue.pushMiddle(3);
        queue.pushMiddle(4);
        System.out.println("queue.popFront() = " + queue.popFront());
        System.out.println("queue.popMiddle() = " + queue.popMiddle());
        System.out.println("queue.popMiddle() = " + queue.popMiddle());
        System.out.println("queue.popBack() = " + queue.popBack());
        System.out.println("queue.popFront() = " + queue.popFront());

    }
}

class FrontMiddleBackQueue {
    private LinkedList<Integer> left;
    private LinkedList<Integer> right;

    public FrontMiddleBackQueue() {
        left = new LinkedList<>();
        right = new LinkedList<>();
    }

    public void pushFront(int val) {
        left.addFirst(val);
    }

    public void pushMiddle(int val) {
        balance();
        if (left.size() > right.size()) {
            right.addFirst(left.removeLast());
        }
        left.addLast(val);
    }

    public void pushBack(int val) {
        right.addLast(val);
    }

    public int popFront() {
        if (left.isEmpty() && right.isEmpty()) {
            return -1;
        }
        if (!left.isEmpty()) {
            return left.removeFirst();
        }
        balance();
        return left.removeFirst();
    }

    public int popMiddle() {
        if (left.isEmpty() && right.isEmpty()) {
            return -1;
        }
        balance();
        return left.removeLast();
    }

    public int popBack() {
        if (left.isEmpty() && right.isEmpty()) {
            return -1;
        }
        if (!right.isEmpty()) {
            return right.removeLast();
        }
        balance();
        if (!right.isEmpty()) {
            return right.removeLast();
        } else {
            return left.removeLast();
        }
    }

    private void balance() {
        if (left.size() == right.size() || left.size() == right.size() + 1) {
            return;
        }
        while (left.size() < right.size()) {
            left.addLast(right.removeFirst());
        }
        while (right.size() < left.size() - 1) {
            right.addFirst(left.removeLast());
        }
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
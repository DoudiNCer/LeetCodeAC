package LeetCode.L341;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {
    private int[] data;
    private int index;

    public NestedIterator(List<NestedInteger> nestedList) {
        LinkedList<Integer> tmp = new LinkedList<>();
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                tmp.add(ni.getInteger());
            } else {
                tmp.addAll(parseNestedInteger(ni));
            }
        }
        data = new int[tmp.size()];
        {
            int i = 0;
            for (Integer integer : tmp) {
                data[i] = integer;
                i++;
            }
        }
        index = 0;
    }

    private List<Integer> parseNestedInteger(NestedInteger nestedInteger) {
        List<Integer> result = new LinkedList<>();
        if (nestedInteger.isInteger()) {
            result.add(nestedInteger.getInteger());
        } else {
            for (NestedInteger ni : nestedInteger.getList()) {
                result.addAll(parseNestedInteger(ni));
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        return data[index++];
    }

    @Override
    public boolean hasNext() {
        return index < data.length;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
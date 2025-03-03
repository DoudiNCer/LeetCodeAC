package LeetCode.L690;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 你有一个保存员工信息的数据结构，它包含了员工唯一的 id ，重要度和直系下属的 id 。
 *
 * 给定一个员工数组 employees，其中：
 *
 * employees[i].id 是第 i 个员工的 ID。
 * employees[i].importance 是第 i 个员工的重要度。
 * employees[i].subordinates 是第 i 名员工的直接下属的 ID 列表。
 * 给定一个整数 id 表示一个员工的 ID，返回这个员工和他所有下属的重要度的 总和。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
 * 输出：11
 * 解释：
 * 员工 1 自身的重要度是 5 ，他有两个直系下属 2 和 3 ，而且 2 和 3 的重要度均为 3 。因此员工 1 的总重要度是 5 + 3 + 3 = 11 。
 *
 *
 * 示例 2：
 *
 *
 *
 * 输入：employees = [[1,2,[5]],[5,-3,[]]], id = 5
 * 输出：-3
 * 解释：员工 5 的重要度为 -3 并且没有直接下属。
 * 因此，员工 5 的总重要度为 -3。
 *
 *
 * 提示：
 *
 * 1 <= employees.length <= 2000
 * 1 <= employees[i].id <= 2000
 * 所有的 employees[i].id 互不相同。
 * -100 <= employees[i].importance <= 100
 * 一名员工最多有一名直接领导，并可能有多名下属。
 * employees[i].subordinates 中的 ID 都有效。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, 5, Arrays.asList(2, 3)));
        employees.add(new Employee(2, 3, new ArrayList<>()));
        employees.add(new Employee(3, 3, new ArrayList<>()));
        System.out.println("s.getImportance(employees, 1) = " + s.getImportance(employees, 1));
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
}

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee e : employees){
            employeeMap.put(e.id, e);
        }
        Deque<Integer> ids = new ArrayDeque<>();
        ids.add(id);
        int result = 0;
        while (!ids.isEmpty()){
            Employee e = employeeMap.get(ids.pop());
            result += e.importance;
            ids.addAll(e.subordinates);
        }
        return result;
    }
}
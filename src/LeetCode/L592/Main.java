package LeetCode.L592;

/**
 * 给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。
 *
 * 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
 *
 *
 *
 * 示例 1:
 *
 * 输入: expression = "-1/2+1/2"
 * 输出: "0/1"
 *  示例 2:
 *
 * 输入: expression = "-1/2+1/2+1/3"
 * 输出: "1/3"
 * 示例 3:
 *
 * 输入: expression = "1/3-1/2"
 * 输出: "-1/6"
 *
 *
 * 提示:
 *
 * 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。
 * 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。
 * 输入只包含合法的最简分数，每个分数的分子与分母的范围是  [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。
 * 输入的分数个数范围是 [1,10]。
 * 最终结果的分子与分母保证是 32 位整数范围内的有效整数。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.fractionAddition(\"-1/2+1/2\") = " + s.fractionAddition("-1/2+1/2"));
        System.out.println("s.fractionAddition(\"-1/2+1/2+1/3\") = " + s.fractionAddition("-1/2+1/2+1/3"));
    }
}

class Solution {
    public String fractionAddition(String expression) {
        if (expression.charAt(0) != '+' && expression.charAt(0) != '-' ){
            expression = "+" + expression;
        }
        char[] exp = expression.toCharArray();
        int le = exp.length;
        int s = 0, m = 1;
        for (int i = 0; i < le;){
            if (exp[i + 1] == '0') {
                continue;
            }
            int sym = exp[i] == '+' ? 1 : -1;
            int ps = 0, pm = 0;
            i++;
            while (exp[i] != '/'){
                ps *= 10;
                ps += exp[i] - '0';
                i++;
            }
            i++;
            while (i < le && exp[i] != '+' && exp[i] != '-'){
                pm *= 10;
                pm += exp[i] - '0';
                i++;
            }
            int g = gcd(ps, pm);
            if (g > 0){
                ps /= g;
                pm /= g;
            }
            ps *= sym;
            int l = lcm(m, pm);
            s = s * (l / m) + ps * (l / pm);
            m = l;
            g = gcd(s, m);
            s /= g;
            m /= g;
        }
        return s + "/" + m;
    }

    private int gcd(int u, int v){
        if (u == 0){
            return v;
        }
        if (u < 0){
            u = -u;
        }
        if (u < v){
            int t = u;
            u = v;
            v = t;
        }
        while (v != 0){
            int tmp = u % v;
            u = v;
            v = tmp;
        }
        return u;
    }
    private int lcm(int a, int b){
        if (a == 0){
            return 0;
        }
        if (a < 0) {
            a = -a;
        }
        return a * b / gcd(a, b);
    }
}


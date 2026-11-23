/*
    设计一个算法，该算法接受一个整数流并检索该流中最后 k 个整数的乘积。

    实现 ProductOfNumbers 类：

    ProductOfNumbers() 用一个空的流初始化对象。
    void add(int num) 将数字 num 添加到当前数字列表的最后面。
    int getProduct(int k) 返回当前数字列表中，最后 k 个数字的乘积。你可以假设当前列表中始终 至少 包含 k 个数字。
    题目数据保证：任何时候，任一连续数字序列的乘积都在 32 位整数范围内，不会溢出。

    提示：

    0 <= num <= 100
    1 <= k <= 4 * 10^4
    add 和 getProduct 最多被调用 4 * 10^4 次。
    在任何时间点流的乘积都在 32 位整数范围内。


    进阶：您能否 同时 将 GetProduct 和 Add 的实现改为 O(1) 时间复杂度，而不是 O(k) 时间复杂度？
*/

struct ProductOfNumbers {
    arr: Vec<i32>,
}

/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl ProductOfNumbers {
    fn new() -> Self {
        ProductOfNumbers { arr: vec![] }
    }

    fn add(&mut self, num: i32) {
        if num == 0 {
            self.arr = vec![];
            return;
        }
        if let Some(l) = self.arr.last() {
            self.arr.push(num * *l);
        } else {
            self.arr.push(num);
        }
    }

    fn get_product(&mut self, k: i32) -> i32 {
        let le = self.arr.len();
        let k = k as usize;
        if le < k {
            0
        } else if le == k {
            return self.arr[le - 1];
        } else {
            return self.arr[le - 1] / self.arr[le - k - 1];
        }
    }
}

/*
 * Your ProductOfNumbers object will be instantiated and called as such:
 * let obj = ProductOfNumbers::new();
 * obj.add(num);
 * let ret_2: i32 = obj.get_product(k);
 */

#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let mut productOfNumbers = ProductOfNumbers::new();
        productOfNumbers.add(3); // [3]
        productOfNumbers.add(0); // [3,0]
        productOfNumbers.add(2); // [3,0,2]
        productOfNumbers.add(5); // [3,0,2,5]
        productOfNumbers.add(4); // [3,0,2,5,4]
        let p = productOfNumbers.get_product(2);
        assert_eq!(p, 20);
        let p = productOfNumbers.get_product(3);
        assert_eq!(p, 40);
        let p = productOfNumbers.get_product(4);
        assert_eq!(p, 0);
        productOfNumbers.add(8); // [3,0,2,5,4,8]
        let p = productOfNumbers.get_product(2);
        assert_eq!(p, 32);
    }
}

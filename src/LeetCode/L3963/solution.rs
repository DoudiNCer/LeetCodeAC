use super::Solution;

/*
    给你两个整数 m 和 n，分别表示网格的行数和列数。
    
    请你构造 任意 一个只包含字符 '.' 和 '#' 的 m x n 网格，其中：
    
    '.' 表示空单元格。
    '#' 表示障碍物单元格。
    有效路径 是满足以下条件的空单元格序列：
    
    从左上角单元格 (0, 0) 开始。
    在右下角单元格 (m - 1, n - 1) 结束。
    只能向：
    右移动，从 (i, j) 到 (i, j + 1)，或者
    下移动，从 (i, j) 到 (i + 1, j)。
    返回任意一个从左上角到右下角 恰好只有一条有效路径 的网格。
    
    提示：
    
    1 <= m, n <= 25
*/

impl Solution {
    pub fn create_grid(m: i32, n: i32) -> Vec<String> {
        let mut res = Vec::with_capacity(m as usize);
        res.push(String::from_utf8(vec![u8::try_from('.').unwrap(); n as usize]).unwrap());
        for i in 1..m {
            res.push(String::from_utf8(||->Vec<u8>{
                let mut zml = vec![u8::try_from('#').unwrap(); n as usize - 1];
                zml.push(u8::try_from('.').unwrap());
                zml
            }()).unwrap());
        }
        res
    }
}
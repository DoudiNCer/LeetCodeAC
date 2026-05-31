use super::Solution;

/*
    给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。

    你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。

    提示：

    n == matrix.length == matrix[i].length
    1 <= n <= 20
    -1000 <= matrix[i][j] <= 1000
*/

impl Solution {
    pub fn rotate(matrix: &mut Vec<Vec<i32>>) {
        let n = matrix.len();
        for i in 0..n - 1 {
            for j in i + 1..n {
                (matrix[i][j], matrix[j][i]) = (matrix[j][i], matrix[i][j])
            }
        }
        for i in 0..n {
            for j in 0..n {
                let jj = n - 1 - j;
                if j >= jj {
                    break;
                }
                (matrix[i][j], matrix[i][jj]) = (matrix[i][jj], matrix[i][j]);
            }
        }
    }
}

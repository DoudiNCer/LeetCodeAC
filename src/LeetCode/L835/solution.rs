use super::Solution;

/*
    给你两个图像 img1 和 img2 ，两个图像的大小都是 n x n ，用大小相同的二进制正方形矩阵表示。二进制矩阵仅由若干 0 和若干 1 组成。

    转换 其中一个图像，将所有的 1 向左，右，上，或下滑动任何数量的单位；然后把它放在另一个图像的上面。该转换的 重叠 是指两个图像 都 具有 1 的位置的数目。

    请注意，转换 不包括 向任何方向旋转。越过矩阵边界的 1 都将被清除。

    最大可能的重叠数量是多少？

    提示：

    n == img1.length == img1[i].length
    n == img2.length == img2[i].length
    1 <= n <= 30
    img1[i][j] 为 0 或 1
    img2[i][j] 为 0 或 1
*/

impl Solution {
    pub fn largest_overlap(img1: Vec<Vec<i32>>, img2: Vec<Vec<i32>>) -> i32 {
        let n = img1.len();
        let mut img1bit = vec![0i32; n];
        let mut img2bit = vec![0i32; n];
        for i in 0..n {
            for j in 0..n {
                img1bit[i] += (1 << j) * img1[i][j];
                img2bit[i] += (1 << j) * img2[i][j];
            }
        }

        let mut res = 0;
        for dj in 0..n {
            for di in 0..n {
                let mut overlaps = vec![0; 4];
                for i in 0..n - di {
                    let mut ovs = vec![0; 4];
                    ovs[0] = img1bit[i] & (img2bit[i + di] >> dj);
                    ovs[1] = img1bit[i + di] & (img2bit[i] >> dj);
                    ovs[2] = (img1bit[i] >> dj) & (img2bit[i + di]);
                    ovs[3] = (img1bit[i + di] >> dj) & (img2bit[i]);
                    for x in 0..4 {
                        let mut ov = ovs[x];
                        while ov > 0 {
                            overlaps[x] += ov & 1;
                            ov >>= 1;
                        }
                    }
                }
                for i in 0..4 {
                    res = res.max(overlaps[i]);
                }
            }
        }
        res
    }
}

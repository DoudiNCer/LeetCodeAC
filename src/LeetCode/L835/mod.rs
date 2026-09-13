mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let img1 = vec![vec![1, 1, 0], vec![0, 1, 0], vec![0, 1, 0]];
        let img2 = vec![vec![0, 0, 0], vec![0, 1, 1], vec![0, 0, 1]];
        let result = Solution::largest_overlap(img1, img2);

        assert_eq!(result, 3)
    }
    #[test]
    fn case2() {
        let img1 = vec![vec![1]];
        let img2 = vec![vec![1]];
        let result = Solution::largest_overlap(img1, img2);

        assert_eq!(result, 1)
    }
    #[test]
    fn case3() {
        let img1 = vec![vec![0]];
        let img2 = vec![vec![0]];
        let result = Solution::largest_overlap(img1, img2);

        assert_eq!(result, 0)
    }
    #[test]
    fn case4() {
        let img1 = vec![
            vec![0, 0, 0, 0, 1],
            vec![0, 0, 0, 0, 0],
            vec![0, 0, 0, 0, 0],
            vec![0, 0, 0, 0, 0],
            vec![0, 0, 0, 0, 0],
        ];
        let img2 = vec![
            vec![0, 0, 0, 0, 0],
            vec![0, 0, 0, 0, 0],
            vec![0, 0, 0, 0, 0],
            vec![0, 0, 0, 0, 0],
            vec![1, 0, 0, 0, 0],
        ];
        let result = Solution::largest_overlap(img1, img2);

        assert_eq!(result, 1)
    }
}

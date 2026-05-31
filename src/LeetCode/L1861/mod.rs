mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let ibox = vec![
            vec!['#', '.', '#']
        ];
        let result = Solution::rotate_the_box(ibox);
        let target = vec![
            vec!['.'],
            vec!['#'],
            vec!['#']
        ];

        assert_eq!(result, target)
    }
    #[test]
    fn case2() {
        let ibox = vec![
            vec!['#', '.', '*', '.'],
            vec!['#', '#', '*', '.']
        ];
        let result = Solution::rotate_the_box(ibox);
        let target = vec![
            vec!['#', '.'],
            vec!['#', '#'],
            vec!['*', '*'],
            vec!['.', '.']
        ];

        assert_eq!(result, target)
    }
    #[test]
    fn case3() {
        let ibox = vec![
            vec!['#', '#', '*', '.', '*', '.'],
            vec!['#', '#', '#', '*', '.', '.'],
            vec!['#', '#', '#', '.', '#', '.']
        ];
        let result = Solution::rotate_the_box(ibox);
        let target = vec![
            vec!['.', '#', '#'],
            vec!['.', '#', '#'],
            vec!['#', '#', '*'],
            vec!['#', '*', '.'],
            vec!['#', '.', '*'],
            vec!['#', '.', '.']
        ];

        assert_eq!(result, target)
    }
}

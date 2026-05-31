mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    use std::collections::LinkedList;
    #[test]
    fn case1() {
        let mass = 10;
        let asteroids = vec![3, 9, 19, 5, 21];
        let result = Solution::asteroids_destroyed(mass, asteroids);

        assert_eq!(result, true)
    }
    #[test]
    fn case2() {
        let mass = 5;
        let asteroids = vec![4, 9, 23, 4];
        let result = Solution::asteroids_destroyed(mass, asteroids);

        assert_eq!(result, false)
    }
}

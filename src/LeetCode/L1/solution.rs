use super::Solution;

use std::collections::HashMap;
impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut hm: HashMap<i32, i32> = HashMap::new();
        for (i, &v) in nums.iter().enumerate() {
            hm.insert(v, i as i32);
        }
        for (i, &v) in nums.iter().enumerate() {
            if let Some(j) = hm.get(&(target - v)) {
                let ii = i as i32;
                if ii != *j {
                    return vec![i as i32, *j];
                }
            }
        }
        vec![]
    }
}

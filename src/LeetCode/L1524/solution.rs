use super::Solution;

/*
    给你一个整数数组 arr 。请你返回和为 奇数 的子数组数目。
    
    由于答案可能会很大，请你将结果对 10^9 + 7 取余后返回。
    
    提示：
    
    1 <= arr.length <= 10^5
    1 <= arr[i] <= 100
*/

const MOD:i64 = 1_000_000_007;

impl Solution {
    pub fn num_of_subarrays(arr: Vec<i32>) -> i32 {
        let mut odd = false;
        let mut even_cnt = 1i64;
        let mut res = 0i64;
        for (i, num) in arr.iter().enumerate() {
            if num & 1 == 1 {
                odd = !odd;
            }
            if odd {
                res += even_cnt;
                res %= MOD;
            } else { 
                res += (i+1) as i64 - even_cnt;
                res %= MOD;
                even_cnt += 1;
            }
        }
        (res % MOD) as i32
    }
}

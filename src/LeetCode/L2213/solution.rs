use super::Solution;

/*
    给你一个下标从 0 开始的字符串 s 。另给你一个下标从 0 开始、长度为 k 的字符串 queryCharacters ，一个下标从 0 开始、长度也是 k 的整数 下标 数组 queryIndices ，这两个都用来描述 k 个查询。

    第 i 个查询会将 s 中位于下标 queryIndices[i] 的字符更新为 queryCharacters[i] 。

    返回一个长度为 k 的数组 lengths ，其中 lengths[i] 是在执行第 i 个查询 之后 s 中仅由 单个字符重复 组成的 最长子字符串 的 长度 。

    提示：

    1 <= s.length <= 10^5
    s 由小写英文字母组成
    k == queryCharacters.length == queryIndices.length
    1 <= k <= 10^5
    queryCharacters 由小写英文字母组成
    0 <= queryIndices[i] < s.length
*/

use std::collections::BTreeMap;

impl Solution {
    pub fn longest_repeating(
        s: String,
        query_characters: String,
        query_indices: Vec<i32>,
    ) -> Vec<i32> {
        let n = s.len();
        let mut s = s.into_bytes();
        let qc = query_characters.as_bytes();
        let mut segs: BTreeMap<usize, usize> = BTreeMap::new();
        let mut lens: BTreeMap<i32, i32> = BTreeMap::new();

        // init segments by initial data
        let mut l = 0;
        while l < n {
            let mut r = l;
            while r < n && s[l] == s[r] {
                r += 1;
            }
            segs.insert(l, r - 1);
            *lens.entry((r - l) as i32).or_insert(0) += 1;
            l = r;
        }

        let mut res = Vec::with_capacity(query_indices.len());

        // process every query
        for (i, &q) in query_indices.iter().enumerate() {
            let q = q as usize;
            // if the string will be changed, process the segments and lens
            if s[q] != qc[i] {
                // remove the origin segment
                let (&L, &R) = segs.range(..=q).next_back().unwrap();
                segs.remove(&L);
                let old_len = (R - L + 1) as i32;
                *lens.get_mut(&old_len).unwrap() -= 1;
                if lens[&old_len] == 0 {
                    lens.remove(&old_len);
                }

                // insert the left and right part of old segment
                if L <= q - 1 {
                    segs.insert(L, q - 1);
                    *lens.entry((q - L) as i32).or_insert(0) += 1;
                }
                if R >= q + 1 {
                    segs.insert(q + 1, R);
                    *lens.entry((R - q) as i32).or_insert(0) += 1;
                }

                // generate the segment of q
                let mut nL = q;
                let mut nR = q;

                if q + 1 < n && s[q + 1] == qc[i] {
                    // merge the new segment with the next segment
                    if let Some(&next_r) = segs.get(&(q + 1)) {
                        segs.remove(&(q + 1));
                        let next_len = (next_r - q) as i32;
                        *lens.get_mut(&next_len).unwrap() -= 1;
                        if lens[&next_len] == 0 {
                            lens.remove(&next_len);
                        }
                        nR = next_r;
                    }
                }

                if q > 0 && s[q - 1] == qc[i] {
                    // merge the new segment with the past segment
                    if let Some((&past_l, &past_r)) = segs.range(..q).next_back() {
                        segs.remove(&past_l);
                        let past_len = (past_r - past_l + 1) as i32;
                        *lens.get_mut(&past_len).unwrap() -= 1;
                        if lens[&past_len] == 0 {
                            lens.remove(&past_len);
                        }
                        nL = past_l;
                    }
                }

                // change the string and save the new segment
                segs.insert(nL, nR);
                *lens.entry((nR - nL + 1) as i32).or_insert(0) += 1;
                s[q] = qc[i];
            }
            res.push(*lens.keys().next_back().unwrap());
        }
        res
    }
}

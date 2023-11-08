package LeetCode.L36;

import java.util.HashSet;
import java.util.Set;

/**
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] c0 = new char[][]{{'5','3','.','.','7','.','.','.','.'}, {'6','.','.','1','9','5','.','.','.'}, {'.','9','8','.','.','.','.','6','.'}, {'8','.','.','.','6','.','.','.','3'}, {'4','.','.','8','.','3','.','.','1'}, {'7','.','.','.','2','.','.','.','6'}, {'.','6','.','.','.','.','2','8','.'}, {'.','.','.','4','1','9','.','.','5'}, {'.','.','.','.','8','.','.','7','9'}};
        System.out.println("s.isValidSudoku(c0) = " + s.isValidSudoku(c0));
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> judgeSet = new HashSet<>(9);
        for (int x = 0; x < 9; x++){
            for (int y = 0; y < 9; y++){
                if (board[x][y] != '.' ){
                    if (judgeSet.contains(board[x][y])){
                        return false;
                    }
                    judgeSet.add(board[x][y]);
                }
            }
            judgeSet.clear();
        }
        for (int y = 0; y < 9; y++){
            for (int x = 0; x < 9; x++){
                if (board[x][y] != '.' ){
                    if (judgeSet.contains(board[x][y])){
                        return false;
                    }
                    judgeSet.add(board[x][y]);
                }
            }
            judgeSet.clear();
        }
        for (int x = 0; x < 9; x += 3){
            for (int y = 0; y < 9; y += 3){
                for (int i = 0; i < 3; i++){
                    for (int j = 0; j < 3; j++){
                        if (board[x + i][y + j] != '.'){
                            if (judgeSet.contains(board[x + i][y + j])){
                                return false;
                            }
                            judgeSet.add(board[x + i][y + j]);
                        }
                    }
                }
                judgeSet.clear();
            }
        }
        return true;
    }
}
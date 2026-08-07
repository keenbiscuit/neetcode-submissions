class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] row = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int value = board[i][j] - '0' - 1;
                if (row[value]) return false;
                row[value] = true;
            }
        }

        for (int i = 0; i < 9; i++) {
            boolean[] col = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') continue;
                int value = board[j][i] - '0' - 1;
                if (col[value]) return false;
                col[value] = true;
            }
        }
        
        boolean[][][] squares = new boolean[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int value = (board[i][j] - '0') - 1;
                int newR = (i/3) % 3;
                int newC = (j/3) % 3;
                if (squares[newR][newC][value]) return false;
                squares[newR][newC][value] = true;
            }
        }
        return true;
    }
}
/**
check rows
boolean[] seen = boolean[10];
check columns 
boolean[] seen = boolean[10];
check squares
boolean[][] buckets = new boolean[3][3][9];
int newR = (i/3)
int newC = (j/3) % 3 
   j
0, 1, 2 , 3,4,5.   6, 7, 8.   i 
9,10,11  12,13,14. 15,16,17
18,19,20 21,22,23. 24,25,26
27
*/
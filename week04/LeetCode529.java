public class LeetCode529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (click.length < 2) return board;
        int r = click[0];
        int c = click[1];
        char grid = board[r][c];
        if (grid == 'M') {
            // 如果一个地雷（'M'）被挖出，游戏就结束了 - 把它改为 'X'
            board[r][c] = 'X';
        } else {
            return clickE(board, r, c);
        }

        return board;

    }

    // click E
    char[][] clickE(char[][] board, int r, int c) {
        // 判断周围是否有地雷
        int mineNum0 = getMineNum(board, r, c);
        if (mineNum0 > 0) {
            board[r][c] = (char)(mineNum0 + '0');
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!isArea(board, r - 1 + i, c - 1 + j)) continue;
                    if (!isTarget(board, r - 1 + i, c - 1 + j, 'E')) continue;
                    // 判断周围是否有地雷 如果没有 修改状态
                    int mineNum = getMineNum(board, r - 1 + i, c - 1 + j);
                    if (mineNum > 0) {
                        board[r - 1 + i][c - 1 + j] = (char)(mineNum + '0');
                    } else {
                        board[r - 1 + i][c - 1 + j] = 'B';
                        board = clickE(board, r - 1 + i, c - 1 + j);
                    }
                }
            }
        }
        return board;
    }

    //get around mine num
    int getMineNum(char[][] board, int r, int c) {
        int num = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                if (!isArea(board, r - 1 + i, c - 1 + j)) continue;
                // 判断是否地雷
                if (isTarget(board, r - 1 + i, c - 1 + j, 'M')) num++;
            }
        }
        return num;
    }

    // is gird
    boolean isArea(char[][] board, int r, int c) {
        return !(r < 0 || r >= board.length || c < 0 || c >= board[0].length);
    }

    // is mine
    boolean isTarget(char[][] board, int r, int c, char target) {
        return board[r][c] == target;
    }
}

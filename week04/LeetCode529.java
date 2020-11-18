public class LeetCode529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (click.length < 2) return board;
        int r = click[0];
        int c = click[1];
        char grid = board[r][c];

        如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1' 到 '8'），表示相邻地雷的数量。
        如果在此次点击中，若无更多方块可被揭露，则返回面板。

        switch (grid) {

            case 'M':
                // 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'
                board[r][c] = 'X';

            case 'E':
                // 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'）
                // 并且所有和其相邻的未挖出方块都应该被递归地揭露

        }

    }

    // click E
    char[][] clickE(char[][] board, int r, int c) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                if (!isArea(board, r - 1 + i, c - 1 + i)) continue;
                if (!isTarget(board, r - 1 + i, c - 1 + i, 'E')) continue;
                // 判断周围是否有地雷 如果没有 修改状态
                int mineNum = getMineNum(board, r - 1 + i, c - 1 + i);
                if (mineNum > 0) {
                    board[r - 1 + i][c - 1 + i] = (char) mineNum;
                }else {
                    board[r - 1 + i][c - 1 + i] = 'B';
                }
            }
        }
    }

    //get around mine num
    int getMineNum(char[][] board, int r, int c) {
        int num = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                if (!isArea(board, r - 1 + i, c - 1 + i)) continue;
                // 判断是否地雷
                if (isTarget(board, r - 1 + i, c - 1 + i, 'M')) num++;
            }
        }
        return num;
    }

    // is around by mine
    boolean isAroundByMine(char[][] board, int r, int c) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                if (!isArea(board, r - 1 + i, c - 1 + i)) continue;
                // 判断是否地雷
                if (isTarget(board, r - 1 + i, c - 1 + i, 'M')) return true;
            }
        }
        return false;
    }

    // is gird
    boolean isArea(char[][] board, int r, int c) {
        return (r < 0 || r >= board.length || c < 0 || c >= board[0].length);
    }

    // is mine
    boolean isTarget(char[][] board, int r, int c, char target) {
        return board[r][c] == target;
    }
}

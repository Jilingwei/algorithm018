public class LeetCode200 {
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    // grid 格子，row 行，column 列
    void dfs(char[][] grid, int r, int c) {
        // 判断当前格子是否存在
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return;
        // 非岛屿直接返回
        if (grid[r][c] != '1') return;
        // 把这个格子改成 2
        grid[r][c] = '2';
        // 搜索附近的格子
        dfs(grid, r + 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r - 1, c);
        dfs(grid, r, c - 1);
    }
}

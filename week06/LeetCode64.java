import java.util.HashMap;

public class LeetCode64 {
    HashMap<String, Integer> visited = new HashMap<>();

    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;
                if (i > 0 && j > 0) {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                } else if (i > 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else grid[i][j] = grid[i][j - 1] + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
//        return dp(grid, 0, 0);
    }

    // 效率较低
    int dp(int[][] grid, int x, int y) {
        if (visited.containsKey(x + "," + y)) return visited.get(x + "," + y);
        if (x + 1 == grid.length && y + 1 == grid[0].length) {
            visited.put(x + "," + y, grid[x][y]);
            return grid[x][y];
        } else if (x + 1 == grid.length) {
            int temp = dp(grid, x, y + 1) + grid[x][y];
            visited.put(x + "," + y, temp);
            return temp;
        } else if (y + 1 == grid[0].length) {
            int temp = dp(grid, x + 1, y) + grid[x][y];
            visited.put(x + "," + y, temp);
            return temp;
        } else {
            int temp = Math.min(dp(grid, x + 1, y), dp(grid, x, y + 1)) + grid[x][y];
            visited.put(x + "," + y, temp);
            return temp;
        }
    }
}

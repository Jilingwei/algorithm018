import java.util.HashSet;
import java.util.Set;

public class LeetCode874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        // 方向 dircetion 0 北 y+; 1东 x+; 2 南 y-; 3 西 x-;
        int dircetion = 0;
        int x = 0;
        int y = 0;
        int next_x = 0;
        int next_y = 0;
        int ans = 0;
        // 障碍点集合
        Set<String> set = new HashSet<>();
        for (int[] arr:obstacles) set.add(arr[0] + "," + arr[1]);

        for (int i = 0; i < commands.length; i++) {
            // dircetion % 4取得当前方向
            // 向右90度
            if (commands[i] == -1) dircetion = (dircetion + 1) % 4;
            // 向左90度
            if (commands[i] == -2) dircetion = (dircetion + 3) % 4;
            // 直走
            if (commands[i] > 0){
                // 一步步移动 判断是否会走到障碍点
                for (int j = 0; j < commands[i]; j++) {
                    // 移动
                    if (dircetion == 0) next_y = y + 1;
                    if (dircetion == 1) next_x = x + 1;
                    if (dircetion == 2) next_y = y - 1;
                    if (dircetion == 3) next_x = x - 1;
                    // 判断是否在障碍点
                    if (set.contains(next_x + "," + next_y)){
                        // 碰到障碍点 取消本轮移动
                        next_x = x;
                        next_y = y;
                        break;
                    } else{
                        // 非障碍点 正常移动
                        x = next_x;
                        y = next_y;
                        ans = Math.max(ans, x*x + y*y);
                    }
                }
            }
        }
        return ans;
    }
}

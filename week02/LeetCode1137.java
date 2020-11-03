import java.util.HashMap;

public class LeetCode1137 {

    HashMap<Integer, Integer> map = new HashMap<>();

    public int tribonacci(int n) {
        return fib(n);
    }

    int fib(int n){
        if(n == 1 || n == 2){
            return 1;
        }else if(n == 0){
            return 0;
        }else if (map.containsKey(n)){
            // 已经出现过的值不必重复计算
            return map.get(n);
        }
        else{
            // 记录出现过的值
            int result = fib(n - 1) + fib(n - 2) + fib(n - 3);
            map.put(n, result);
            return result;
        }
    }
}

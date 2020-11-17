import java.util.*;

class LeetCode127 {
    // BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        // Set<String> visited = new HashSet<>();
        boolean[] visited = new boolean[wordList.size()];
        Queue<String> queue = new LinkedList<>();
        int count = 0;
        queue.offer(beginWord);
        int beginIndex = wordList.indexOf(beginWord);
        if (beginIndex != -1) {
            visited[beginIndex] = true;
        }

        while (queue.size() > 0) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currString = queue.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    String s = wordList.get(j);
                    // 访问过的不需要重新访问
                    if (visited[j]) continue;
                    // 不能转换的跳过
                    if (!canConvert(currString, s)) continue;
                    // 返回结果
                    if (s.equals(endWord)) return count + 1;
                    visited[j] = true;
                    queue.offer(s);
                }
            }
        }

        return 0;

    }

    public boolean canConvert(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int diffNum = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++diffNum;
            }
            if (diffNum > 1) return false;
        }
        return diffNum == 1;
    }


    // 双向BFS解法
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {

        int end = wordList.indexOf(endWord);
        if (end == -1) {
            return 0;
        }

        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();

        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();

        queue1.offer(beginWord);
        queue2.offer(endWord);

        visited1.add(beginWord);
        visited2.add(endWord);

        Set<String> allWordSet = new HashSet<>(wordList);
        // 步数
        int result = 0;

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            // 步数 + 1
            result++;
            // 找到扩散节点少的一头
            if (queue2.size() < queue1.size()) {
                Queue<String> temp_queue = queue1;
                queue1 = queue2;
                queue2 = temp_queue;

                Set<String> temp_set = visited1;
                visited1 = visited2;
                visited2 = temp_set;
            }

            int size = queue1.size();
            for (int i = 0; i < size; i++) {
                String curr_string = queue1.poll();
                char[] chars = curr_string.toCharArray();
                // 逐个位置替换字母
                for (int j = 0; j < curr_string.length(); j++) {
                    // 保存原有的字母
                    char temp_char = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String new_string = new String(chars);
                        // 跳过已经访问过的结果
                        if (visited1.contains(new_string)) continue;
                        // 找到匹配结果
                        if (visited2.contains(new_string)) return result + 1;
                        // 结果在wordList当中
                        if (allWordSet.contains(new_string)) {
                            queue1.offer(new_string);
                            visited1.add(new_string);
                        }
                    }
                    // 复原
                    chars[j] = temp_char;
                }
            }
        }
        return 0;
    }
}

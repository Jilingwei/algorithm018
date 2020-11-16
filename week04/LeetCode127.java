import java.util.*;

class LeetCode127 {
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
}

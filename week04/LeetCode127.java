import java.util.*;

class LeetCode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int count = 0;
        queue.offer(beginWord);
        visited.add(beginWord);

        while (queue.size() > 0){

        }

        return 0;

    }

    public boolean canConvert(String s1, String s2){
        if (s1.length() != s2.length()) return false;
        int diffNum = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++diffNum;
            }
        }


        return diffNum == 1;
    }
}

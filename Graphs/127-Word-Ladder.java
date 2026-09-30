/*
    127. Word Ladder
    Hard
    Topics
    Companies
    A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

    Every adjacent pair of words differs by a single letter.
    Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
    sk == endWord
    Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists
*/

// Using BFS : O(n^2 * m)tc & O(n^2)sc
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) {
            return 0;
        }

        int n = wordList.size();
        int m = wordList.get(0).length();
        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(wordList.get(i), i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cnt = 0;
                for (int k = 0; k < m; k++) {
                    if (wordList.get(i).charAt(k) != wordList.get(j).charAt(k)) {
                        cnt++;
                    }
                }
                if (cnt == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int res = 1;
        Set<Integer> visit = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == beginWord.charAt(i)) {
                    continue;
                }
                String word = beginWord.substring(0, i) + c + beginWord.substring(i + 1);
                if (mp.containsKey(word) && !visit.contains(mp.get(word))) {
                    q.add(mp.get(word));
                    visit.add(mp.get(word));
                }
            }
        }

        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                if (wordList.get(node).equals(endWord)) {
                    return res;
                }
                for (int nei : adj.get(node)) {
                    if (!visit.contains(nei)) {
                        visit.add(nei);
                        q.add(nei);
                    }
                }
            }
        }

        return 0;
    }
}
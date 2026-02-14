class Solution {

    // DFS to build paths
    private void dfs(String word, String beginWord, Map<String, List<String>> parent, List<String> path, List<List<String>> result) {

        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
            return;
        }

        for (String p : parent.get(word)) {
            path.add(p);
            dfs(p, beginWord, parent, path, result);
            path.remove(path.size() - 1);
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();

        if (!dict.contains(endWord)) return result;

        // parent map: child -> list of parents
        Map<String, List<String>> parent = new HashMap<>();

        Set<String> current = new HashSet<>();
        current.add(beginWord);

        Set<String> visited = new HashSet<>();
        boolean found = false;

        while (!current.isEmpty() && !found) {
            Set<String> next = new HashSet<>();

            for (String w : current) visited.add(w);

            for (String word : current) {

                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String newWord = new String(arr);

                        if (!dict.contains(newWord)) continue;
                        if (visited.contains(newWord)) continue;

                        if (newWord.equals(endWord)) found = true;

                        next.add(newWord);

                        parent.putIfAbsent(newWord, new ArrayList<>());
                        parent.get(newWord).add(word);
                    }
                    arr[i] = original;
                }
            }
            current = next;
        }

        if (!found) return result;

        List<String> path = new ArrayList<>();
        path.add(endWord);

        dfs(endWord, beginWord, parent, path, result);

        return result;
    }
}

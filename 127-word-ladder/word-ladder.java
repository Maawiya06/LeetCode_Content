class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> ans = new HashSet<>(wordList);
        if(!ans.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int change = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String word = q.poll();
                if(word.equals(endWord)) return change;

                for(int j = 0; j < word.length(); j++){
                    for(int k = 'a'; k <= 'z'; k++){
                        char arr[] = word.toCharArray();
                        arr[j] = (char) k;

                        String s = new String(arr);
                        if(ans.contains(s) && !visited.contains(s)){
                            q.offer(s);
                            visited.add(s);
                        }
                    }
                }
            }
            ++change;
        }
        return 0;
    }
}
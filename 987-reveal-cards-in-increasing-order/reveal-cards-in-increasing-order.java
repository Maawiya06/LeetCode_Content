class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck); // for sorting

        Queue<Integer> q = new LinkedList<>();
        int n = deck.length;
        int[] ans = new int[n]; 

        // put indices of ans into q
        for (int i = 0; i < n; i++) {
            q.add(i); 
        }

        // reverse simulate + filling using sorted deck
        for (int i = 0; i < n; i++) {
            // 1. Reveal
            ans[q.poll()] = deck[i];

            // 2. push front to bottom
            if (!q.isEmpty()) {
                q.add(q.poll()); 
            }
        }

        return ans;
    }
}

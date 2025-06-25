class Solution {
    public int findTheWinner(int n, int k) {
        // all player should go into queue
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            q.add(i);
        }

        while(q.size() > 1){
            // simulate the queue
            for(int i = 1; i < k; i++){
                q.add(q.peek());
                q.remove();
            }


            // kth player must be eliminate
            q.remove();
        }

        return q.peek();
    }
}
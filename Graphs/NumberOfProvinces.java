class Solution {

    private void dfs(int node,
                     ArrayList<ArrayList<Integer>> adj,
                     int[] vis) {

        vis[node] = 1;

        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, adj, vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int V = isConnected.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                }
            }
        }

        int[] vis = new int[V];
        int cnt = 0;

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                cnt++;
                dfs(i, adj, vis);
            }
        }

        return cnt;
    }
}

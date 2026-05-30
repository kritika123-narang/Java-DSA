class Solution {

    public ArrayList<Integer> dfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];

        dfs(0, visited, adj, ans);

        return ans;
    }

    private void dfs(int node,boolean[] visited,ArrayList<ArrayList<Integer>> adj,
                     ArrayList<Integer> ans) {

        visited[node] = true;
        ans.add(node);

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj, ans);
            }
        }
    }
}

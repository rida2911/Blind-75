class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;  // Condition 1: Must have exactly n-1 edges

        // Step 1: Build adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]); // Undirected graph
        }

        // Step 2: Use BFS to check connectivity and cycle
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.add(0); // Start from node 0
        visited.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (visited.contains(neighbor)) continue; // Ignore back edge
                visited.add(neighbor);
                queue.add(neighbor);
            }
        }
        return visited.size() == n; // Check if all nodes are visited
    }
}

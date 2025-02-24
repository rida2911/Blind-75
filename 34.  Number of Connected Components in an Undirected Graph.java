class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int count = 0;

        // Step 1: Build adjacency list
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]); // Undirected graph
        }

        // Step 2: BFS to count components
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                count++; // New connected component found
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visited.add(i);

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int neighbor : graph.get(node)) {
                        if (!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }
        return count;
    }
}

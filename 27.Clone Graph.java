class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // HashMap to store cloned nodes
        Map<Node, Node> map = new HashMap<>();

        // Queue for BFS
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        // Clone the first node and put in the map
        map.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            // Iterate through neighbors
            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    // Clone the neighbor if not already cloned
                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                // Connect cloned nodes
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}

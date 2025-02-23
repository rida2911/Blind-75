class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++) 
        graph.add(new ArrayList<>()) ;


        for(int[] pre : prerequisites) 
        graph.get(pre[1]).add(pre[0]);

        int[] visited = new int[numCourses] ;

        for(int i = 0 ; i < numCourses ; i++) {
            if(hasCycle(i, graph,visited)) return false ;
        }
        
        return true ;
    }

    private boolean hasCycle(int node , List<List<Integer>> graph, int[] visited) {
        if(visited[node] ==1) return true ;

        if(visited[node] == 2 ) return false ;

        visited[node] = 1 ;

        for(int neighbor : graph .get(node)) {
            if(hasCycle(neighbor, graph, visited)) 
            return true ;
        }

        visited[node] = 2 ;
        return false ;
    }
}

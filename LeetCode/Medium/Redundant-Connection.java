class Solution {
    
    public static boolean dfs(Map<Integer,List<Integer>> graph, int[] visited,int curNode,int preNode){

        if(visited[curNode] == 1) {
            return true;
        }
        else {
            visited[curNode] = 1;
            List<Integer> integers = graph.get(curNode);
            for (Integer integer : integers) {
                if(preNode != integer){
                    if(dfs(graph , visited , integer, curNode)){
                        return true;
                    }
                }

            }
        }
        return false;
    }
    
    
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        int[] result = new int[2];
        for (int[] edge : edges) {
            if(!graph.containsKey(edge[0])) graph.put(edge[0], new ArrayList<>());
            if(!graph.containsKey(edge[1])) graph.put(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);


            int[] visited = new int[edges.length+1];
            if(dfs(graph,visited,edge[0] , 0)){
                return new int[]{edge[0] , edge[1]};
            }

        }

        return result;
    }
}

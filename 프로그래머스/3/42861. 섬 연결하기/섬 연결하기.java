import java.util.*;

class Solution {
    
    static int[] root;
    static int[] child;
    
    static class Node{
        int edge1;
        int edge2;
        int cost;
        
        Node(int e1, int e2, int cost){
            this.edge1 = e1;
            this.edge2 = e2;
            this.cost = cost;
        }
    }
    
    public int solution(int n, int[][] costs) {
        // 가중치가 작은 간선만 택해서 사이클이 만들어지는지 확인
        
        Queue<Node> q = new PriorityQueue<>(Comparator.comparing(node -> node.cost));
        for(int[] cost : costs){
            q.add(new Node(cost[0], cost[1], cost[2]));
        }
        
        root = new int[n];
        for(int i = 0; i < n; i++)
            root[i] = i;
        child = new int[n];
        Arrays.fill(child, 1);
        
        int ans = 0;
        while(!q.isEmpty()){
            Node node = q.poll();
            int edge1 = node.edge1;
            int edge2 = node.edge2;
            
            int root1 = find(edge1);
            int root2 = find(edge2);
            
            if(root1 == root2){
                continue;
            }
            else{
                ans += node.cost;
                merge(edge1, edge2);
            }
        }
        
        return ans;
    }
    
    private static int find(int edge){
        if(root[edge] == edge)
            return edge;
        return find(root[edge]);
    }
    
    private static void merge(int edge1, int edge2){
        int root1 = find(edge1);
        int root2 = find(edge2);
        
        if(child[root1] > child[root2]){
            child[root1] += child[root2];
            root[root2] = root1;
        }
        else{
            child[root2] += child[root1];
            root[root1] = root2;
        }
    }
}
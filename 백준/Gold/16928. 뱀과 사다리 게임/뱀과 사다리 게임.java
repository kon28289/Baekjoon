import java.io.*;
import java.util.*;

public final class Main {

    static class Node{
        int num;
        int cost;

        Node(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> ladder = new HashMap<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            ladder.put(x,y);
        }

        Map<Integer,Integer> snake = new HashMap<>();
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            snake.put(u,v);
        }

        Queue<Node> que = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        que.add(new Node(0, 0));
        int[][] graph = new int[10][10];
        boolean[][] visited = new boolean[10][10];
        visited[0][0] = true;


        while(!que.isEmpty()){
            Node node = que.poll();
            int row = node.num / 10;
            int col = node.num % 10;

            if(node.num == 99){
                System.out.println(node.cost);
                return;
            }

            for(int i = 0; i < 6; i++){
                int tmp = node.num + i + 1;
                if(tmp >= 100)
                    continue;
                if(ladder.get(tmp) != null){
                    tmp = ladder.get(tmp);
                }
                else if(snake.get(tmp) != null){
                    tmp = snake.get(tmp);
                }

                int newRow = tmp / 10;
                int newCol = tmp % 10;
                if(!visited[newRow][newCol]){
                    visited[newRow][newCol] = true;
                    que.add(new Node(tmp, node.cost + 1));
                }
            }
        }
    }
}
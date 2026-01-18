import java.io.*;
import java.util.*;

public final class Main {

    static class Node{
        int vertex;
        int cost;

        Node(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    static List<Node>[] list;
    static List<Node>[] reverseList;
    static int[] go;
    static int[] back;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        reverseList = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startV = Integer.parseInt(st.nextToken());
            int endV = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[startV].add(new Node(endV, cost));
            reverseList[endV].add(new Node(startV, cost));
        }

        solveGo(X, N);

        solveBack(X, N);

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < N + 1; i++) {
            max = Math.max(go[i] + back[i], max);
        }
        System.out.println(max);


    }

    private static void solveGo(int X,  int N){
        Queue<Node> que = new PriorityQueue<>(Comparator.comparing(n -> n.cost));
        que.add(new Node(X, 0));
        boolean[] visited = new boolean[N + 1];
        go = new int[N + 1];
        Arrays.fill(go, Integer.MAX_VALUE);
        go[X] = 0;

        while(!que.isEmpty()){
            Node node = que.poll();
            int now = node.vertex;
            visited[now] = true;

            for(Node next : reverseList[now]){
                int cost = next.cost;

                if(visited[next.vertex])
                    continue;
                if(go[next.vertex] > go[now] + cost){
                    go[next.vertex] = go[now] + cost;
                    que.add(new Node(next.vertex, go[next.vertex]));
                }
            }
        }
    }

    private static void solveBack(int X, int N) {
        Queue<Node> que = new PriorityQueue<>(Comparator.comparing(n -> n.cost));
        que.add(new Node(X, 0));
        boolean[] visited = new boolean[N + 1];
        back = new int[N + 1];
        Arrays.fill(back, Integer.MAX_VALUE);
        back[X] = 0;

        while(!que.isEmpty()){
            Node node = que.poll();
            int now = node.vertex;
            visited[now] = true;

            for(Node next : list[now]){
                int cost = next.cost;

                if(visited[next.vertex])
                    continue;
                if(back[next.vertex] > back[now] + cost){
                    back[next.vertex] = back[now] + cost;
                    que.add(new Node(next.vertex, back[next.vertex]));
                }
            }
        }
    }

}

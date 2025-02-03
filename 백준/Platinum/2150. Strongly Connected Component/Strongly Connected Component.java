import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static ArrayList<Integer>[] back_graph;
    static boolean[] visited;
    static ArrayList<Integer> tmp = new ArrayList<>();
    static Stack<Integer> stack = new Stack<>();
    static ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    static void dfs1(int node){
        visited[node] = true;

        for(int i : graph[node]){
            if(!visited[i]){
                dfs1(i);
            }
        }
        stack.push(node);
    }

    static void dfs2(int node){
        visited[node] = true;

        for(int i : back_graph[node]){
            if(!visited[i]){
                dfs2(i);
            }
        }
        tmp.add(node);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V, N;
        V = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V];
        back_graph = new ArrayList[V];
        for(int i = 0; i < V; i++){
            graph[i] = new ArrayList<>();
            back_graph[i] = new ArrayList<>();
        }

        visited = new boolean[V];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            graph[start].add(end);
            back_graph[end].add(start);
        }

        // 강한 연결 요소를 찾음
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs1(i);
            }
        }


        // 방문 배열 초기화
        Arrays.fill(visited, false);

        // 그래프 순회하여 강한 연결 요소의 원소들을 출력
        for(int i = 0; i < V; i++){
            if(stack.isEmpty()){
                continue;
            }
            int node = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);

            if(!visited[node]){
                dfs2(node);
                tmp.sort((a,b) -> a - b);
                tmp.add(-1);
                result.add(new ArrayList<>(tmp));
                tmp.clear();
            }
        }
        result.sort((a,b) -> a.get(0) - b.get(0));

        System.out.println(result.size());
        for(ArrayList<Integer> list : result){
            for(int tmp : list){
                if(tmp != -1){
                    System.out.print(tmp+1 + " ");
                    continue;
                }
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}


import java.io.*;
import java.util.*;

public final class Main {

    static class Node{
        int num;
        String path;

        Node(int num, String path){
            this.num = num;
            this.path = path;
        }
    }

    static int D(int n){
        return (2 * n) % 10000;
    }
    static int S(int n){
        if(n == 0)
            return 9999;
        else
            return n - 1;
    }
    static int L(int n){
        return (n % 1000) * 10 + n / 1000;
    }
    static int R(int n){
        return (n / 10) + (n % 10) * 1000;
    }

    static int oper(int n1, int n2){
        switch (n1){
            case 0 : {
                return D(n2);
            }
            case 1 : {
                return S(n2);
            }
            case 2 : {
                return L(n2);
            }
            case 3 : {
                return R(n2);
            }
        }
        return n1;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Queue<Node> que = new ArrayDeque<>();
            boolean[] visited = new boolean[10000];
            visited[start] = true;
            que.add(new Node(start, ""));

            while(!que.isEmpty()){
                Node node = que.poll();
                int num = node.num;

                if(num == end){
                    System.out.println(node.path);
                    break;
                }

                char[] opers = {'D','S','L','R'};
                for(int j = 0; j < 4; j++){
                    int result = oper(j, num);
                    if(!visited[result]){
                        que.add(new Node(result, node.path + opers[j]));
                        visited[result] = true;
                    }
                }
            }
        }

    }
}
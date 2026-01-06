import java.io.*;
import java.util.*;

public final class Main {

    static class Node{
        long num;
        int count;

        Node(long num, int count){
            this.num = num;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(a, 1));

        while(!que.isEmpty()){
            Node node = que.poll();

            if(node.num == b){
                System.out.println(node.count);
                return;
            }

            long num = node.num * 2L;
            if(num <= b){
                que.add(new Node(num, node.count + 1));
            }

            num = node.num * 10L + 1;
            if(num <= b){
                que.add(new Node(num, node.count + 1));
            }
        }

        System.out.println(-1);

    }
}

import java.io.*;
import java.util.*;

public final class Main {

    static class Node{
        int start;
        int end;

        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        List<Node> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Node(start, end));
        }
        list.sort(Comparator.comparingInt((Node o) -> o.end).thenComparing(o -> o.start));
        int answer = 1;
        Node node = list.get(0);
        int end = node.end;
        for(int i = 1; i < n; i++){
            Node next = list.get(i);
            if(next.start >= end){
                answer++;
                end = next.end;
            }
        }
        System.out.println(answer);

    }
}
import java.io.*;
import java.util.*;

public class Main{

    static class Node{
        int id;
        int startTime;
        int endTime;

        Node(int id, int startTime, int endTime){
            this.id = id;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        StringTokenizer st;

        Queue<Node> q = new PriorityQueue<>((a,b) -> Integer.compare(a.startTime, b.startTime));

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int lno = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            q.add(new Node(lno, start, end));
        }

        Queue<Integer> endTimes = new PriorityQueue<>();
        int ans = 1;
        while(!q.isEmpty()){
            Node node = q.poll();

            if(!endTimes.isEmpty()){
                while(!endTimes.isEmpty() && node.startTime >= endTimes.peek()){
                    endTimes.poll();
                }
                endTimes.add(node.endTime);
                ans = Math.max(ans, endTimes.size());
            }
            else{
                endTimes.add(node.endTime);
            }
        }

        System.out.println(ans);
    }
}
import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());

            if(tmp > 0){
                queue.add(tmp);
            }
            else{
                if(queue.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(queue.poll());
            }
        }

    }
}
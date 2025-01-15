import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean[] graph = new boolean[end + 1];
        Arrays.fill(graph, true);
        graph[1] = false;

        // 에라토스테네스의 체

        for(int i = 2; i <= Math.sqrt(end); i++){
            if(graph[i]){
               for(int j = 2; j < graph.length; j++){
                   if(i * j >= graph.length)
                       break;
                   graph[i * j] = false;
               }
            }
        }

        for(int i = start; i <= end; i++){
            if(graph[i])
                System.out.println(i);
        }
    }

}


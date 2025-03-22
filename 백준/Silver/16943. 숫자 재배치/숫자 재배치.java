import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int answer = -1;

    static void backTracking(String A, String B, String C, int[] visited) {
        for(int i = 0; i < A.length(); i++){
            StringBuilder sb = new StringBuilder(C);

            if(C.length() == A.length()){
                if(sb.charAt(0) == '0'){
                    return;
                }
                int c = Integer.parseInt(C);
                int b = Integer.parseInt(B);
                if(c < b)
                    answer = Math.max(c, answer);
                return;
            }
            if(visited[i] == 0){
                sb.append(A.charAt(i));
                visited[i] = 1;
                backTracking(A, B, sb.toString(), visited);
                sb.deleteCharAt(sb.length()-1);
                visited[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();
        String C = "";

        if(A.length() > B.length()){
            System.out.println(answer);
            return;
        }
        int pointer = -1;
        int[] visisted = new int[A.length()];
        backTracking(A, B, C, visisted);
        System.out.println(answer);
    }
}

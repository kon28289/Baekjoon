import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        long sum = 0;
        long xorSum = 0;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = 0;
            if(st.hasMoreTokens())
                b = Integer.parseInt(st.nextToken());

            if(a == 1){
                sum += b;
                xorSum ^= b;
            }
            else if(a == 2){
                sum -= b;
                xorSum ^= b;
            }
            else if (a == 3){
                sb.append(sum + "\n");
            }
            else if(a == 4){
                sb.append(xorSum + "\n");
            }
        }
        System.out.println(sb);
    }
}

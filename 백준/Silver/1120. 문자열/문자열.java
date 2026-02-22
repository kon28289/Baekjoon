import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        int ALen = A.length();
        int BLen = B.length();
        int diffLen = BLen - ALen;

        int count = 0;
        int ans = Integer.MAX_VALUE;
        if(diffLen == 0){
            for (int i = 0; i < ALen; i++) {
                if(A.charAt(i) != B.charAt(i))
                    count++;
            }
            ans = count;
        }
        else{
            for (int i = 0; i < diffLen + 1; i++) {
                count = 0;
                for (int j = 0; j < ALen; j++) {
                    if(A.charAt(j) != B.charAt(i + j)){
                        count++;
                    }
                }
                ans = Math.min(ans, count);
            }
        }
        System.out.println(ans);
    }
}

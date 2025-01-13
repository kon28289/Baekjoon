import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int s = 0;
        StringTokenizer st;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            int n = 0;
            if(st.hasMoreTokens())
                n = Integer.parseInt(st.nextToken()) - 1;

            if(oper.equals("add")){
                s = s | (1 << n);
            }
            else if(oper.equals("remove")){
                s = s & ~(1 << n);
            }
            else if(oper.equals("toggle")){
                s = s ^ (1 << n);
            }
            else if(oper.equals("empty")){
                s = 0;
            }
            else if(oper.equals("all")){
                s = ((1 << 21) - 1) | s;
            }
            else if(oper.equals("check")){
                if((s & (1 << n)) != 0)
                    sb.append(1 + "\n");
                else
                    sb.append(0 + "\n");
            }
        }
        System.out.println(sb);
    }
}

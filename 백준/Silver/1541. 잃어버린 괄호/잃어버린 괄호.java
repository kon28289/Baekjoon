import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int answer = 0;
        String s = st.nextToken();
        String[] tokens = s.split("-");

        for(int i = 0; i < tokens.length; i++){
            String[] arr = tokens[i].split("\\+");
            int tmp = 0;
            for(int j = 0; j < arr.length; j++){
                tmp += Integer.parseInt(arr[j]);
            }
            if(i == 0)
                answer = tmp;
            else
                answer -= tmp;

        }
        System.out.println(answer);


    }
}
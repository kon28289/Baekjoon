import java.io.*;
import java.util.*;

public final class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            String value = st.nextToken();
            map.put(key, value);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            if(map.containsKey(key)){
                bw.write(map.get(key) + "\n");
                bw.flush();
            }
        }
    }
}
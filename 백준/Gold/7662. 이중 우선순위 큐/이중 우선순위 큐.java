import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for(int j = 0; j < m; j++){
                st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                int tmp = Integer.parseInt(st.nextToken());

                if(c == 'I'){
                    map.merge(tmp, 1, Integer::sum);
                }
                else if(c == 'D'){
                    int num = 0;

                    if(tmp == -1 && !map.isEmpty()) {
                        num = map.firstKey();
                        if(map.get(num) == 1)
                            map.remove(num);
                        else
                            map.put(num, map.get(num) - 1);
                    }
                    else if(tmp == 1 && !map.isEmpty()) {
                        num = map.lastKey();
                        if(map.get(num) == 1)
                            map.remove(num);
                        else
                            map.put(num, map.get(num) - 1);
                    }
                }
            }
            if(map.isEmpty()){
                bw.write("EMPTY\n");
            }
            else{
                bw.write(map.lastKey() + " " + map.firstKey() + "\n");
            }
        }
        bw.flush();

    }
}
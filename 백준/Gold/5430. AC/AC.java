import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for(int i = 0; i < t; i++){
            Deque<String> deq = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            st = new StringTokenizer(br.readLine());
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for(int j = 0; j < s.length(); j++){
                char c = s.charAt(j);
                StringBuilder sb = new StringBuilder();
                while(c != '[' && c != ']' && c != ','){
                    sb.append(c);
                    c = s.charAt(++j);
                }
                if(sb.length() != 0)
                    deq.add(sb.toString());
            }

            int flag = 0;
            int reversed = 0;
            for(int j = 0; j < command.length(); j++){
                char c = command.charAt(j);
                if(c == 'R'){
                    reversed = (reversed == 0) ? 1 : 0;
                }
                if(c == 'D'){
                    if(reversed == 1){
                        if(deq.pollLast() == null)
                            flag = 1;
                    }
                    else
                        if(deq.poll() == null)
                            flag = 1;
                }
            }

            if(flag == 1)
                bw.append("error\n");
            else {
                int localCount = 0;
                StringBuilder sb = new StringBuilder();
                sb.append('[');
                int range = deq.size();
                for(int k = 0; k < range; k++){
                    if(reversed == 1){
                        sb.append(deq.peekLast());
                        localCount++;
                        if(localCount != range) {
                            sb.append(',');
                        }
                        deq.pollLast();
                    }
                    else{
                        sb.append(deq.peek());
                        localCount++;
                        if(localCount != range) {
                            sb.append(',');
                        }
                        deq.poll();
                    }
                }
                sb.append(']');
                sb.append('\n');
                bw.write(sb.toString());
            }
        }
        bw.append('\n');
        bw.flush();
    }


}
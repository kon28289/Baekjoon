import java.io.*;
import java.sql.Array;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String bomb = br.readLine();

        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            deque.add(now);
            if(deque.size() >= bomb.length()){
                Deque<Character> tmp = new ArrayDeque<>();
                for (int j = bomb.length() - 1; j >= 0; j--) {
                    if(bomb.charAt(j) != deque.peekLast()){
                        int range = tmp.size();
                        for (int k = 0; k < range; k++) {
                            deque.add(tmp.pollLast());
                        }
                        break;
                    }
                    else{
                        tmp.add(deque.pollLast());
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int range = deque.size();
        for (int i = 0; i < range; i++) {
            sb.append(deque.poll());
        }
        if(range == 0){
            System.out.println("FRULA");
            return;
        }
        System.out.println(sb);
    }


}

import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int i = 1;
        while((i * (i + 1) / 2 < X)){
            i++;
        }

        int k = X - (i * (i - 1) / 2);

        if(i % 2 == 0){
            System.out.print(k + "/" + (i - k  + 1));
        }
        else{
            System.out.println((i - k + 1) + "/" + k);
        }

    }

}

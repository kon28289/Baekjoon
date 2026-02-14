import java.io.*;
import java.util.*;

public final class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] ones = {"","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"","X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};

        int countI = 0;
        int countV = 0;
        int countX = 0;
        int countL = 0;
        int countC = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'I')
                countI++;
            else if(s.charAt(i) == 'V')
                countV++;
            else if(s.charAt(i) == 'X')
                countX++;
            else if(s.charAt(i) == 'L')
                countL++;
            else if(s.charAt(i) == 'C')
                countC++;
        }

        StringBuilder sb;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int cI = 0;
                int cV = 0;
                int cX = 0;
                int cL = 0;
                int cC = 0;
                sb = new StringBuilder();
                sb.append(tens[i]).append(ones[j]);

                for (int k = 0; k < sb.length(); k++) {
                    if(sb.charAt(k) == 'I')
                        cI++;
                    else if(sb.charAt(k) == 'V')
                        cV++;
                    else if(sb.charAt(k) == 'X')
                        cX++;
                    else if(sb.charAt(k) == 'L')
                        cL++;
                    else if(sb.charAt(k) == 'C')
                        cC++;
                }

                if(cI == countI && cV == countV && cX == countX && cL == countL && cC == countC){
                    System.out.println(sb);
                    return;
                }


            }
        }

    }
}

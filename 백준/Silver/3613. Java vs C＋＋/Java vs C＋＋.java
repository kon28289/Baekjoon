import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        // 먼저 C++, Java 변수명 컨벤션에 맞는지를 확인
        // 이후 C++이면 Java로 변환, Java이면 C++로 변환

        int underBarCount = 0;
        int upperCaseCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '_'){
                underBarCount++;
            }
            else if(c < 'a'){
                upperCaseCount++;
            }
        }

        StringBuilder sb = new StringBuilder();
        // ERROR 조건
        // 처음이 대문자, 처음이 밑줄, 마지막이 밑줄, 밑줄 2개 연속, 대문자와 밑줄이 함께

        if(underBarCount > 0 && upperCaseCount > 0){
            System.out.println("Error!");
        }
        else if(s.charAt(0) == '_' || s.charAt(0) - 'Z' < 0 || s.charAt(s.length() - 1) == '_'){
            System.out.println("Error!");
        }
        else{
            if(underBarCount > 0){
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if(c != '_'){
                        sb.append(c);
                    }
                    else{
                        i++;
                        char next = s.charAt(i);
                        if(next == '_'){
                            System.out.println("Error!");
                            return;
                        }
                        sb.append((char) (next - 32));
                    }
                }
            }
            else{
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if(c > 'Z'){
                        sb.append(c);
                    }
                    else{
                        sb.append('_').append((char) (c + 32));
                    }
                }
            }
        }
        System.out.println(sb);
    }
}

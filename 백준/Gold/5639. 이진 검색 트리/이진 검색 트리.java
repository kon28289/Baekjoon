import java.io.*;
import java.util.*;

public final class Main {

    static class Node{
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
        }

        void insert(int value){
            if(value < this.value){
                if(this.left == null)
                    this.left = new Node(value);
                else
                    this.left.insert(value);
            }
            else{
                if(this.right == null)
                    this.right = new Node(value);
                else
                    this.right.insert(value);
            }
        }
    }

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int n = Integer.parseInt(br.readLine());
        Node node = new Node(n);

        while((line = br.readLine()) != null){
            if(line.isBlank())
                break;
            int num = Integer.parseInt(line);
            node.insert(num);
        }
        post(node);
    }

    static void post(Node node){
        if(node.left != null) {
            post(node.left);
        }
        if(node.right != null) {
            post(node.right);
        }
        System.out.println(node.value);
    }


}

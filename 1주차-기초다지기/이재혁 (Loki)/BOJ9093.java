import java.util.*;
import java.io.*;

public class BOJ9093 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String input = br.readLine();

            StringBuilder sb = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            for(int j=0; j<input.length(); j++){
                if(input.charAt(j) != ' ')
                    stack.add(input.charAt(j));
                else{
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                }
            }

            if(!stack.isEmpty()){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
            }

            System.out.println(sb);
        }
    }
}
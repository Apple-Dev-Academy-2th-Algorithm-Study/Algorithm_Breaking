import java.util.*;
import java.io.*;

public class BOJ17413 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<input.length(); i++){
            if(input.charAt(i) == '<'){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append('<');
                i += 1;
                while(input.charAt(i) != '>'){
                    sb.append(input.charAt(i));
                    i++;
                }
                sb.append('>');
            }
            else if(input.charAt(i) == ' '){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(' ');
            }
            else{
                stack.add(input.charAt(i));
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
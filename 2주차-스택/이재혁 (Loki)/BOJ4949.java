import java.util.*;
import java.io.*;

public class BOJ4949 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        StringBuilder sb = new StringBuilder();

        while(!((input = br.readLine()).equals("."))){
            Stack<Character> stack = new Stack<>();
            char[] list = input.toCharArray();
            String answer = "yes";
            for(int i=0; i<list.length; i++){
                if(list[i] == '('){
                    stack.add('(');
                }
                else if(list[i] == '['){
                    stack.add('[');
                }
                else if(list[i] == ')'){
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    }
                    else{
                        answer = "no";
                        break;
                    }
                }
                else if(list[i] == ']'){
                    if(!stack.isEmpty() && stack.peek() == '['){
                        stack.pop();
                    }
                    else{
                        answer = "no";
                        break;
                    }
                }
            }
            if(stack.isEmpty())
                sb.append(answer).append("\n");
            else sb.append("no\n");
        }
        System.out.println(sb);

    }
}

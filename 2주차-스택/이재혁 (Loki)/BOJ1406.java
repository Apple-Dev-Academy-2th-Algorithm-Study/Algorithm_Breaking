import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
* Stack 2개를 사용하여
* 텍스트 편집기를 구현하는 아이디어
* */

public class BOJ1406 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] input = br.readLine().toCharArray();

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(char c : input){
            stack1.add(c);
        }

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);
            if(command == 'L'){
                if(!stack1.isEmpty()){
                    stack2.add(stack1.pop());
                }
            }
            else if(command == 'D'){
                if(!stack2.isEmpty()){
                    stack1.add(stack2.pop());
                }
            }
            else if(command == 'B'){
                if(!stack1.isEmpty()){
                    stack1.pop();
                }
            }
            else if(command == 'P'){
                char inputChar = st.nextToken().charAt(0);
                stack1.add(inputChar);
            }
        }

        while(!stack1.isEmpty()){
            stack2.add(stack1.pop());

        }

        while(!stack2.isEmpty()){
            sb.append(stack2.pop());
        }
        System.out.println(sb);

    }
}


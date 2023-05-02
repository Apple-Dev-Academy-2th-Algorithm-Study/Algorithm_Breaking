import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ1874 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        int point = 1;
        for(int i=0; i<n; i++){
            int inputNum = Integer.parseInt(br.readLine());
            if(stack.isEmpty() || stack.peek() < inputNum){
                while(point != inputNum){
                    stack.add(point);
                    sb.append("+\n");
                    point++;
                }
                stack.add(point);
                sb.append("+\n");
                point++;

                stack.pop();
                sb.append("-\n");
            }
            else if(stack.peek() > inputNum){
                sb = new StringBuilder();
                sb.append("NO\n");
                break;
            }
            else if(stack.peek() == inputNum){
                stack.pop();
                sb.append("-\n");
            }
        }
        System.out.println(sb);
    }
}

import java.util.*;
import java.io.*;

public class BOJ10866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("push_front")){
                int temp = Integer.parseInt(st.nextToken());
                deque.addFirst(temp);
            }
            else if(command.equals("push_back")){
                int temp = Integer.parseInt(st.nextToken());
                deque.addLast(temp);
            }
            else if(command.equals("pop_front")){
                if(deque.isEmpty())
                    sb.append("-1\n");
                else sb.append(deque.pollFirst()).append("\n");
            }
            else if(command.equals("pop_back")){
                if(deque.isEmpty())
                    sb.append("-1\n");
                else sb.append(deque.pollLast()).append("\n");
            }
            else if(command.equals("size")){
                sb.append(deque.size()).append("\n");
            }
            else if(command.equals("empty")){
                if(deque.isEmpty())
                    sb.append("1\n");
                else sb.append("0\n");
            }
            else if(command.equals("front")){
                if(deque.isEmpty())
                    sb.append("-1\n");
                else sb.append(deque.peekFirst()).append("\n");
            }
            else if(command.equals("back")){
                if(deque.isEmpty())
                    sb.append("-1\n");
                else sb.append(deque.peekLast()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
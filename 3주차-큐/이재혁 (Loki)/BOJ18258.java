import java.io.*;
import java.util.*;

public class BOJ18258 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int n =Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            if(a.equals("push")){
                deque.addLast(Integer.parseInt(st.nextToken()));
            }
            else if(a.equals("pop")){
                if(deque.isEmpty()){
                    sb.append("-1\n");
                }
                else{
                    sb.append(deque.pollFirst()).append("\n");
                }
            }
            else if(a.equals("size")){
                sb.append(deque.size()).append("\n");
            }
            else if(a.equals("empty")){
                if(!deque.isEmpty()){
                    sb.append("0\n");
                }
                else{
                    sb.append("1\n");
                }
            }
            else if(a.equals("front")){
                if(deque.isEmpty()){
                    sb.append("-1\n");
                }
                else{
                    sb.append(deque.peekFirst()).append("\n");
                }
            }
            else if(a.equals("back")){
                if(deque.isEmpty()){
                    sb.append("-1\n");
                }
                else{
                    sb.append(deque.peekLast()).append("\n");
                }
            }
        }
        System.out.println(sb);

    }
}

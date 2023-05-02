import java.util.*;
import java.io.*;

public class BOJ1158 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // Queue에 1부터 n까지의 숫자를 넣는다.
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++){
            queue.add(i);
        }

        while(queue.size() != 1){

            // Queue에서 맨 앞의 정수를 꺼내서 맨 뒤에 넣는다 -> K-1번 반복
            for(int i=0; i<m-1; i++){
                int temp = queue.poll();
                queue.add(temp);
            }
            // K번째 정수는 꺼내서 정답 배열에 넣는다.
            sb.append(queue.poll()).append(", ");
        }

        sb.append(queue.poll()).append(">");
        System.out.println(sb);


    }
}

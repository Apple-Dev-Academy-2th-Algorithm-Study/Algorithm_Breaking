import java.util.*;
import java.io.*;

public class BOJ2161 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        // Queue에 1부터 n까지의 숫자를 넣는다.
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++){
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();

        // Queue의 사이즈가 1이 될때까지 계속 반복문을 돈다.
        while(queue.size() > 1){
            // Queue에서 맨 앞의 값을 빼서 정답 StringBuilder에 넣는다.
            sb.append(queue.poll()).append(" ");

            // Queue에서 맨 앞의 값을 하나 빼서 Queue 맨 뒤에 넣는다.
            queue.add(queue.poll());
        }

        // Queue에 남아있는 한개의 숫자를 정답 StringBuilder에 넣는다.
        sb.append(queue.poll());

        // 정답 출력
        System.out.println(sb);
    }
}


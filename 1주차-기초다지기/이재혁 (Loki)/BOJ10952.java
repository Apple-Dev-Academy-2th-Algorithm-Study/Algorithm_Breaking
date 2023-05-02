import java.util.*;
import java.io.*;

public class BOJ10952 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 입력이 0 0 인 경우 = 마지막 입력이므로 반복문 탈출
            if(n == 0 && m == 0)
                break;
            else System.out.println(n+m);
        }

    }
}
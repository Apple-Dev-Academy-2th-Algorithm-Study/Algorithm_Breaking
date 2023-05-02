import java.util.*;
import java.io.*;

/*
* 모래시계 모양으로 출력을 할 때
* n X n 모양으로 끝에 공백까지 출력하면 정답으로 처리 안해줌;;
*/

public class BOJ2446 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n-1; i++){
            for(int j=0; j<i; j++)
                sb.append(" ");

            for(int j=i; j<2*n-1-i; j++)
                sb.append("*");

            sb.append("\n");
        }

        for(int i=0; i<n; i++){
            for(int j=i; j<n-1; j++)
                sb.append(" ");

            for(int j=0; j<2*i+1; j++)
                sb.append("*");

            if(i!=n-1)
                sb.append("\n");
        }
        System.out.println(sb);
    }
}
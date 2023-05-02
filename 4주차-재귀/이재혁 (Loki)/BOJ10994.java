import java.util.*;
import java.io.*;

public class BOJ10994 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] map = new char[4*n - 3][4*n - 3];
        for(int i=0; i<4*n - 3; i++){
            for(int j=0; j<4*n-3; j++){
                map[i][j] = ' ';
            }
        }

        int len = 4*n - 3;

        int start = 0;
        int end = len;

        for(int i=0; i<n; i++){
            for(int j=start; j<end; j++){
                map[start][j] = '*';
                map[len-start-1][j] = '*';
                map[j][start] = '*';
                map[j][len-start-1] = '*';
            }
            start += 2;
            end -= 2;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<4*n-3; i++){
            for(int j=0; j<4*n-3; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

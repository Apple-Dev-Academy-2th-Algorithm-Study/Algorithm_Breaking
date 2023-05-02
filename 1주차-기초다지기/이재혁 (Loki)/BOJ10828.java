import java.util.*;
import java.io.*;

public class BOJ10828 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[10001];
        int point = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")){
                array[point] = Integer.parseInt(st.nextToken());
                point += 1;
            }
            else if(command.equals("pop")){
                if(point != 0) {
                    point -= 1;
                    sb.append(array[point]).append("\n");
                }
                else
                    sb.append("-1\n");
            }
            else if(command.equals("size")){
                sb.append(point).append("\n");
            }
            else if(command.equals("empty")){
                if(point == 0)
                    sb.append("1\n");
                else sb.append("0\n");
            }
            else if(command.equals("top")){
                if(point != 0) {
                    point--;
                    sb.append(array[point]).append("\n");
                    point++;
                }
                else sb.append("-1\n");
            }
        }

        System.out.println(sb);

    }
}
import java.util.*;
import java.io.*;

public class BOJ10845 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")){
                arrayList.add(Integer.parseInt(st.nextToken()));
            }
            else if(command.equals("pop")){
                if(arrayList.size() != 0) {
                    sb.append(arrayList.get(0)).append("\n");
                    arrayList.remove((int)0);
                }
                else sb.append("-1\n");
            }
            else if(command.equals("size")){
                sb.append(arrayList.size()).append("\n");
            }
            else if(command.equals("empty")){
                if(arrayList.size() != 0)
                    sb.append("0\n");
                else sb.append("1\n");
            }
            else if(command.equals("front")){
                if(arrayList.size() != 0)
                    sb.append(arrayList.get(0)).append("\n");
                else sb.append("-1\n");
            }
            else if(command.equals("back")){
                if(arrayList.size() != 0)
                    sb.append(arrayList.get(arrayList.size()-1)).append("\n");
                else sb.append("-1\n");
            }
        }

        System.out.println(sb);

    }
}
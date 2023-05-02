import java.util.*;
import java.io.*;

class Pair{
    int index;
    int value;

    Pair(int index, int value){
        this.index = index;
        this.value = value;
    }
}

public class BOJ17298 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Pair[] list = new Pair[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            list[i] = new Pair(i, Integer.parseInt(st.nextToken()));
        }

        // 정답 배열
        int[] answer = new int[n];

        // 인덱스들을 Stack에 저장할 예정
        Stack<Pair> stack = new Stack<>();

        for(int i=0; i<n; i++){
            if(stack.isEmpty() || list[stack.peek().index].value >= list[i].value){
                stack.add(list[i]);
            }
            else if(list[stack.peek().index].value < list[i].value){
                while(!stack.isEmpty() && list[stack.peek().index].value < list[i].value){
                    int temp = stack.pop().index;
                    answer[temp] = list[i].value;
                }
                stack.add(list[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int s : answer){
            if(s == 0){
                sb.append("-1").append(" ");
            }
            else
                sb.append(s).append(" ");
        }

        System.out.println(sb);

    }
}

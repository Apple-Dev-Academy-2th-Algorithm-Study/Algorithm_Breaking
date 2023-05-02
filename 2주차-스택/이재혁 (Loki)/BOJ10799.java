import java.util.*;
import java.io.*;

public class BOJ10799 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        int steelBarCount = 0;
        int steelBarSum = 0;
        for(int i=0; i<input.length; i++){
            if(input[i] == '('){
                if(i+1 < input.length && input[i+1] == ')'){
                    steelBarSum += steelBarCount;
                    i++;
                }
                else{
                    steelBarCount += 1;
                }
            }
            else if(input[i] == ')'){
                steelBarCount -= 1;
                steelBarSum += 1;
            }
        }

        System.out.println(steelBarSum);
    }
}

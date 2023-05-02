import java.io.*;
import java.util.*;

// Class 객체에 implements Comparable<T>를 사용하여
// Class 객체의 정렬 기준을 만들 수 있다.
class Document implements Comparable<Document> {
    int index;
    int important;
    public Document(int index, int important){
        this.index = index;
        this.important = important;
    }

    @Override
    public int compareTo(Document o) {
        return this.important - o.important;
    }
}

public class BOJ1966 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 전체 문제 개수
        int n = Integer.parseInt(st.nextToken());

        // 전체 문재 개수만큼 반복문
        for(int i=0; i<n; i++){

            st = new StringTokenizer(br.readLine());
            // 문서의 개수
            int len = Integer.parseInt(st.nextToken());
            // 몇번째로 인쇄되는지 궁금한 문서의 index
            int pos = Integer.parseInt(st.nextToken());

            // 각 문서들의 중요도를 저장하는 배열
            int[] values = new int[len];

            Queue<Document> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            // Queue에 각 Document(문서의 index, 문서의 중요도)객체를 만들어서 넣는다
            // 각 문서의 index에 맞는 중요도를 int형 배열에 저장한다.
            for(int j=0; j<len; j++){
                int value = Integer.parseInt(st.nextToken());
                values[j] = value;
                queue.add(new Document(j, value));
            }

            // 중요도를 저장한 int형 배열을 정렬한다.
            Arrays.sort(values);

            // 중요도를 저장한 배열의 맨 끝을 가리킨다.
            // 지금 객체들 중에서 가장 큰 중요도를 가리킨다.
            int point = len-1;

            // 몇번째 순서로 원하는 Document 객체가 꺼내질지 count하는 변수
            int count = 1;

            while(true){
                // Queue의 맨 앞에 있는 Document 객체를 꺼낸다.
                Document d = queue.poll();

                // 해당 Document의 객체의 중요도가 point변수가 가리키는 중요도와 같다면
                if(d.important == values[point]){
                    // 우리가 몊번째로 꺼내질지 궁금해하는 Document 객체였다면
                    if(d.index == pos){
                        // count에 저장된 값을 정답 배열에 넣고 반복문 탈출
                        sb.append(count).append("\n");
                        break;
                    }
                    // 궁금해하는 Document 객체가 아니였다면,
                    else{
                        // Document 꺼낸 횟수 증가 및 중요도 가리키는 변수 -1
                        count++;
                        point--;
                    }
                }
                // 중요도 더 큰 값이 Queue에 있는것이므로 꺼낸 객체는 다시 Queue에 넣는다.
                else queue.add(d);
            }
        }
        System.out.println(sb);
    }
}

import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }
}

class Command{
    int x;
    char c;
    public Command(int x, char c){
        this.x = x;
        this.c = c;
    }
}

public class BOJ3190 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    // 좌 하 우 상

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 가로 세로 1 ~ n까지의 2차원 배열 맵 작성
        int[][] map = new int[n+1][n+1];

        int appleNum = Integer.parseInt(br.readLine());
        // 2차원 배열 Map에 사과 위치 표시 ( 사과 있으면 1, 없으면 0 )
        for(int i=0; i<appleNum; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }

        int changeDirectionNumber = Integer.parseInt(br.readLine());
        // Command 쌍을 저장할 Queue.
        // Command 객체는 second와 direction을 멤버로 갖는다.
        Queue<Command> queue = new LinkedList<>();
        for(int i=0; i<changeDirectionNumber; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            queue.add(new Command(t, direction));
        }

        // 뱀의 몸 위치들을 저장할 Deque
        Deque<Point> deque = new LinkedList<>();
        // 뱀의 시작점 (1, 1)을 Deque에 넣는다.
        deque.add(new Point(1,1));

        int nextMoving = 0;

        int time = 0;
        // 뱀의 머리가 벽에 부딪히거나 자기 몸에 부딪히기 전까지 반복
        while(true){
            time += 1; // 시간 증가

            // Deque 맨 앞에 있는 위치좌표를 꺼낸다 = 뱀의 머리 위치
            Point p = new Point(deque.peek().x, deque.peek().y);

            // 뱀의 머리 위치를 다음 칸으로 움직인다.
            p.x += dx[nextMoving];
            p.y += dy[nextMoving];

            // 뱀의 머리 위치가 벽에 부딪히거나 자기 몸에 부딪히면 반복문 탈출
            if(p.x > n || p.y > n || p.x <= 0 || p.y <= 0 || deque.contains(p)){
                break;
            }

            // 늘어난 뱀의 머리 위치에 사과가 있다면
            if(map[p.x][p.y] == 1){
                // 사과는 먹은걸로 처리하고, 늘어난 뱀의 머리 위치를 Deque 맨앞에 넣는다.
                map[p.x][p.y] = 0;
                deque.addFirst(p);
            }
            // 늘어난 뱀의 머리 위치에 사과가 없다면
            else if(map[p.x][p.y] == 0){
                // 뱀의 머리는 해당 칸으로 옮겨지고 꼬리는 한칸 줄어든다.
                deque.addFirst(p);
                deque.pollLast();
            }

            // Queue 맨 앞의 Command의 시간이 현재 시간과 같다면 -> 방향 조정
            if(!queue.isEmpty() && time == queue.peek().x){
                if(queue.peek().c == 'L'){
                    // 왼쪽으로 회전
                    nextMoving -= 1;
                    if(nextMoving < 0){
                        nextMoving = 3;
                    }
                }
                else if(queue.peek().c == 'D'){
                    // 오른쪽으로 회전
                    nextMoving += 1;
                    if(nextMoving > 3){
                        nextMoving = 0;
                    }
                }
                queue.poll();
            }
        }

        System.out.println(time);

    }
}
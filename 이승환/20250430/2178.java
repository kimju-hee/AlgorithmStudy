import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //미로 초기화
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] maze = new int[N][M];
        for(int i=0;i<N;i++){
            String row = br.readLine();
            
            for(int j=0;j<M;j++){   
                maze[i][j] = row.charAt(j) - '0';
            }
        }
        //BFS 탐색을 하기위한 초기화
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();

        visited[0][0] = true;
        queue.add(new int[]{0, 0});

        //하, 우, 상, 좌 방향
        int[] x = {1, 0, -1, 0};
        int[] y = {0, 1, 0, -1};
        
        //BFS 탐색 시작
        while(!queue.isEmpty()){

            int[] position = queue.poll();
            
            //현재 위치
            int myX = position[0];
            int myY = position[1];

            

            for(int i=0;i<4;i++){
                int nextX = myX + x[i];
                int nextY = myY + y[i];

                //다음 위치가 미로의 범위 안에 있는지 확인
                if (nextX<0 || nextX>=N || nextY<0 || nextY>=M) continue; //범위 체크

                //다음 위치에 방문한 적이 있거나 벽인지 확인
                else if (visited[nextX][nextY] || (maze[nextX][nextY]==0)) continue; 

                //다음 위치를 Queue에 삽입
                queue.add(new int[]{nextX, nextY}); 

                //방문 여부 업데이트
                visited[nextX][nextY] = true;
                //다음 위치의 최소거리 업데이트
                maze[nextX][nextY] = maze[myX][myY] + 1; 
            }
        }
        System.out.println(maze[N-1][M-1]); 
    }
}
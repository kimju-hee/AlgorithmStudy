//BOJ_2178 미로 탐색
//https://www.acmicpc.net/problem/2178

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2178 {
    static int n,m;
    static int[][] graph;
    static boolean[][]visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n=sc.nextInt();
        m=sc.nextInt();
        graph = new int[n][m];
        visited = new boolean[n][m];


        for (int i = 0;i<n;i++){
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }
        bfs(0,0);
        System.out.println(graph[n-1][m-1]);
    }

    static void bfs(int x,int y){
        Queue<int[]> qu=new LinkedList<>();
        qu.add(new int []{x,y});
        visited[x][y]=true;

        while (!qu.isEmpty()){
            int[] current = qu.poll();
            int currx = current[0];
            int curry = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currx + dx[i];
                int nextY = curry + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                    if (graph[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        graph[nextX][nextY] = graph[currx][curry] + 1;
                        qu.add(new int[]{nextX, nextY});
                    }
                }

            }
        }
    }
}

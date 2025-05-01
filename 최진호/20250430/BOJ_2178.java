import java.util.*;
public class BOJ_2178 {
    static int n;
    static int m;
    static boolean[][] visited;
    static int[][] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputNM = sc.nextLine().split(" ");
        n = Integer.parseInt(inputNM[0]);
        m = Integer.parseInt(inputNM[1]);

        visited = new boolean[n][m];
        distance = new int[n][m];
        int[][] miro = new int[n][m];

        for(int i = 0; i<n;i++){
            String input = sc.nextLine();
            for(int j = 0;j<m;j++){
                miro[i][j] = input.charAt(j)-'0';
            }
        }
        // ----------------------------------여기 까지 입력
        bfs(miro);
        System.out.println(distance[n-1][m-1]);
        sc.close();
    }
    public static void bfs(int[][] arr){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        visited[0][0] = true;
        distance[0][0] = 1;

        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,1,-1};
        while(!queue.isEmpty()){
            int[] nowNode = queue.poll();
            for(int i =0;i<4;i++){
                int goX = nowNode[0] + dx[i];
                int goY = nowNode[1] + dy[i];
                if(goX>=0 && goX<n && goY>=0 && goY<m){
                    if(!visited[goX][goY] && arr[goX][goY]==1){
                        queue.add(new int[] {goX,goY});
                        visited[goX][goY] = true;
                        distance[goX][goY] = distance[nowNode[0]][nowNode[1]]+1;
                    }
                }
            }
        }
    }
}

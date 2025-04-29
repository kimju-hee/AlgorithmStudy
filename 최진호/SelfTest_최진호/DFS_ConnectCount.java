package SelfTest_최진호;
import java.util.*;
// 그래프를 입력받고 연결 요소의 개수를 출력하기
// 처음 입력은 n,m 으로 노드수, 에지수로 입력

public class DFS_ConnectCount {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Node
        int m = sc.nextInt(); // Edge

        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v); // 양방향 연결
            graph.get(v).add(u);
        }

        int count = 0;
        for (int i = 0; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
    static void dfs(int node){
        visited[node] = true;
        for(int n : graph.get(node)){
            if(!visited[n]){
                dfs(n);
            }
        }
    }
}

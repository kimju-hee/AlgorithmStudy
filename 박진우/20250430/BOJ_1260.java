//BOJ_1260 DFS와 BFS
//https://www.acmicpc.net/problem/1260


import java.util.*;

public class BOJ_1260 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        graph = new ArrayList[n+1];
        for (int i =1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }

        for (int i = 0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(b);
        }
        for (int i =1;i<=n;i++){
            Collections.sort(graph[i]);
        }
        visited = new boolean[n + 1];
        dfs(v);
        sb.append("\n");
        visited = new boolean[n + 1];
        bfs(v);

        System.out.println(sb);

    }
    static void dfs(int node){
        Stack<Integer> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (visited[current]) continue;

            visited[current] = true;
            sb.append(current).append(" ");

            for (int i = graph[current].size() - 1; i >= 0; i--) {
                int next = graph[current].get(i);
                if (!visited[next]) {
                    stack.push(next);
                }
            }
        }
    }

    static void bfs(int v){
        Queue<Integer>qu=new LinkedList<>();
        qu.offer(v);
        visited[v]=true;

        while (!qu.isEmpty()){
            int current = qu.poll();
            sb.append(current).append(" ");

            for (int next : graph[current]){
                if(!visited[next]){
                    visited[next] = true;
                    qu.offer(next);
                }

            }
        }
    }
}

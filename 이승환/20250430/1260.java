import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        //그래프 초기화
        boolean[][] graph = new boolean[N+1][N+1];
        boolean[] visitedDFS = new boolean[N+1];
        boolean[] visitedBFS = Arrays.copyOf(visitedDFS, visitedDFS.length);

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            graph[vertex1][vertex2] = true;
            graph[vertex2][vertex1] = true;
        }

        DFS(graph, visitedDFS, V);
        BFS(graph, visitedBFS, V);
    }

    public static void DFS(boolean[][] graph, boolean[] visited, int V){

        StringBuilder sb = new StringBuilder();

        //깊이우선탐색을 위한 스택초기화
        Stack<Integer> stack = new Stack<>();
        stack.push(V);
        
        while(!stack.isEmpty()){
            int vertex = stack.pop();
            if (!visited[vertex])sb.append(vertex + " ");
            visited[vertex] = true;
            for(int i=graph.length - 1;i>0;i--){
                if (vertex==i) continue;

                //정점이 연결되어있고, 방문하지 않았다면 스택에 넣기
                if (graph[vertex][i] && !visited[i]){
                    stack.push(i);
                }
            }
        }
        System.out.println(sb);
    }

    public static void BFS(boolean[][] graph, boolean[] visited, int V){
        
        StringBuilder sb = new StringBuilder();

        //너비우선탐색을 위한 큐 초기화
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        visited[V] = true;
        sb.append(V + " ");

        //너비우선탐색 시작
        while(!queue.isEmpty()){
            int vertex = queue.poll();

            for(int i=1;i<graph.length;i++){

                if (vertex == i) continue;
                
                // 정점이 vertex와 연결됐고, 방문하지 않은 정점이라면 큐에 넣기
                if (graph[vertex][i] && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                    sb.append(i + " ");
                }
            }
        }
        System.out.print(sb);
    }
}
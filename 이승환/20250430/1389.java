import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //그래프 초기화
        boolean[][] friends = new boolean[N + 1][N + 1];        

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            friends[A][B] = true;
            friends[B][A] = true;
        }

        KevinBacon(friends);
    }
    public static void KevinBacon(boolean[][] friends){
        
        int length =friends.length; // N + 1
        int minIndex = length + 1; //숫자가 가장 작은 사람
        int minDist = Integer.MAX_VALUE; //최소거리
        

        //모든 정점에 대해 BFS탐색
        for(int i=1;i<length;i++){ 
            
            //거리 배열, 변수 초기화
            int[] distance = new int[length];
            int sum = 0;

            //큐, 방문여부 초기화
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[length];
            queue.offer(i);
            visited[i] = true;

            //BFS탐색
            while(!queue.isEmpty()){

                int vertex = queue.poll();
                for(int k=1;k<length;k++){
                    if (vertex==k) continue;

                    //vertex와 k가 친구관계이고, 아직 거쳐가지 않았다면
                    if (friends[vertex][k] && !visited[k]){
                        queue.offer(k);
                        distance[k] = distance[vertex] + 1; 
                        sum+=distance[k];
                        visited[k] = true;
                    }
                }
            }
            
            if (sum < minDist){
                minDist = sum;
                minIndex = i;
            } 
        }
        System.out.println(minIndex);
    }
}
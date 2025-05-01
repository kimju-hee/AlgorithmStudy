
import java.util.*;

public class BOJ_1389 {
    static int n;
    static int m;
    static ArrayList<ArrayList<Integer>> arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputNM = sc.nextLine().split(" ");
        n = Integer.parseInt(inputNM[0]); //유저 수 , 노드 수
        m = Integer.parseInt(inputNM[1]); //친구 관계 수, 에지 수
        arr = new ArrayList<>();

        for(int i = 0;i<=n;i++){
            arr.add(new ArrayList<Integer>());
        }// 2차원 배열 초기화

        for(int i = 0; i<m;i++){
            String[] input = sc.nextLine().split(" ");
            arr.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
            arr.get(Integer.parseInt(input[1])).add(Integer.parseInt(input[0]));
        }//양방향 노드 입력

        //---------------------------------------------------여기 까지 입력
        int resultValue = Integer.MAX_VALUE; //가장 큰값으로 초기화
        int bestScoreIdx = -1; // 어느 인덱스가 가장 작은지 확인
        for(int i =1; i<=n;i++){ // 1~n 까지 순회
            int score = bfs(i); // bfs 함수에서 점수 리턴
            if(resultValue>score){
                resultValue = score; //가장 작은 값으로 대체
                bestScoreIdx = i;  //가장 작은값의 인덱스
            }
        }
        System.out.println(bestScoreIdx);
        sc.close();
    }
    public static int bfs(int node){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(node);
        boolean[] visited = new boolean[n+1];
        visited[node] = true;
        int[] distance = new int[n+1];

        while(!queue.isEmpty()){
            int nowNode = queue.poll();
                for(int a : arr.get(nowNode)){
                    if(!visited[a]){
                        queue.add(a);
                        visited[a]=true;
                        distance[a]= distance[nowNode]+1;
                }
            }
        }
        int score = 0;
        for(int a : distance){
            score+=a;
        }

        return score;
    }
}

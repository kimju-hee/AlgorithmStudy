import java.util.*;
public class BOJ_1260 {
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int n;
    static int m;
    static boolean[] visitedDFS;
    static boolean[] visitedBFS;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputString = sc.nextLine().split(" ");
        n = Integer.parseInt(inputString[0]); // Node
        m = Integer.parseInt(inputString[1]); // Edge
        int startNode = Integer.parseInt(inputString[2]); // Start

        for(int i = 0;i<=n;i++){
            arr.add(new ArrayList<>());
        }

        visitedDFS = new boolean[n+1];
        visitedBFS = new boolean[n+1];

        for(int i=0;i<m;i++){
            String[] input = sc.nextLine().split(" ");
            int st = Integer.parseInt(input[0]);
            int ed = Integer.parseInt(input[1]);
            arr.get(st).add(ed);
            arr.get(ed).add(st);
        }
        //--------------------------------------입력 받기
        // 정렬 (작은 경우 우선 출력 위해)
        for(int i=0;i<=n;i++){
            Collections.sort(arr.get(i));
        }

        dfs(startNode);
        System.out.println();
        bfs(startNode);
        sc.close();
    }
    public static void dfs(int start){
        System.out.print(start+" ");
        visitedDFS[start] = true;
        for(int a : arr.get(start)){
            if(!visitedDFS[a]){
                dfs(a);
            }
        }

    }
    public static void bfs(int start){
        ArrayDeque <Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visitedBFS[start]= true;

        while (!queue.isEmpty()) {
            int nowIdx = queue.poll();
            System.out.print(nowIdx + " ");//탐색 중인 노드 출력

            for(int a : arr.get(nowIdx)){
                if(!visitedBFS[a]){
                    queue.add(a);
                    visitedBFS[a] = true;
                }
            }

        }
    }
}

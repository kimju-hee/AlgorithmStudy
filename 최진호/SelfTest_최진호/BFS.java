package SelfTest_최진호;
import java.util.*;

public class BFS {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,7};
        System.out.println(bfsCount(arr));
    }

    public static int bfsCount(int[] arr){
        int count = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[arr.length];

        queue.add(0); // 0번 인덱스부터 시작 (값 1)
        visited[0] = true;

        while(!queue.isEmpty()){
            int nowIdx = queue.poll();
            int nowVal = arr[nowIdx];

            for(int nextIdx = 0; nextIdx < arr.length; nextIdx++){
                if(!visited[nextIdx]){
                    if(arr[nextIdx] == nowVal + 1 || arr[nextIdx] == nowVal + 2){
                        queue.add(nextIdx);
                        visited[nextIdx] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
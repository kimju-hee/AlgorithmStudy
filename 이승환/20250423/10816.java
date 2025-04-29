import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //숫자카드배열 초기화
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 순서보장 위해 LinkedHashMap 사용
        // 값의 개수 HashMap에 저장
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int i=0;i<N;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        //목표 카드 개수 출력
        for(int i=0;i<M;i++){
            int value = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(value, 0)).append(" ");
        }
        System.out.println(sb);
    }
}
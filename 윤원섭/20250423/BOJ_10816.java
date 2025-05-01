import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine()); // 상근이 카드 개수
        Map<Integer, Integer> map = new HashMap<>(); // 숫자 → 개수 저장용
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1); // 숫자 개수 카운트
        }
        
        int M = Integer.parseInt(br.readLine()); // 비교할 숫자 개수
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(num, 0)).append(' '); // 결과에 개수 추가
        }
        
        System.out.println(sb);
    }
}

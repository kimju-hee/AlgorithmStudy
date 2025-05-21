import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 배열과 누적합 배열 초기화
        int[][] arr = new int[N + 1][M + 1];
        int[][] cumulSum = new int[N + 1][M + 1];
        for(int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M + 1; j++){
                int value = Integer.parseInt(st.nextToken());
                arr[i][j] = value;
                cumulSum[i][j] = cumulSum[i][j-1] + value;
            }
        }

        StringBuilder sb = new StringBuilder();
        
        //누적합을 이용해서 부분배열의 합 구하기
        int K = Integer.parseInt(br.readLine());
        for(int n = 0; n < K; n++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int result = 0;
            for(int p = i; p < x + 1; p++){
                result += cumulSum[p][y] - cumulSum[p][j - 1];
            }
            sb.append(result + "\n");
        }
        System.out.print(sb);
        
    }
}
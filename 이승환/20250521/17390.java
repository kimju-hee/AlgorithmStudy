import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        //수열 초기화
        int A[] = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        //수열 정렬
        Arrays.sort(A);
        
        //누적합 배열 초기화
        int cumulSum[] = new int[N + 1];
        for (int i = 1; i < N + 1; i++){
            cumulSum[i] = A[i] + cumulSum[i - 1];
        }
        
        //L~R까지의 합 계산
        StringBuilder sb = new StringBuilder();
        for (int question = 1; question < Q + 1; question++){
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            sb.append(cumulSum[R] - cumulSum[L - 1] + "\n");
        }
        
        System.out.println(sb);        
    }
}
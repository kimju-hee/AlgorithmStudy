import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 학생들의 점수를 저장하는 배열 (인덱스 1부터 시작작)
        int[] scores = new int[N + 1];

        // 조가 잘 짜여진 정도의 최댓값을 저장하는 배열 (인덱스 1부터 시작)
        int[] maxDegree = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
             
            int max = scores[i];
            int min = scores[i];
            
            for (int j = i - 1; j > 0; j--){
                //최댓값, 최소값 업데이트
                if (max < scores[j]) max = scores[j];
                if (scores[j] < min) min = scores[j];
                
                // j번째 학생부터 i번째 학생까지 그루핑한 값이 maxDegree보다 크면 업데이트
                
                // j번째 학생부터 i번째 학생까지의 조가 잘 짜여진 정도
                int degree = max - min;
                int jToiMaxDegree = Math.max(maxDegree[i - 1], maxDegree[j - 1] + degree);

                // j번째 학생부터 i번째 학생까지의 정도값 업데이트 
                maxDegree[i] = Math.max(maxDegree[i], jToiMaxDegree);
            }
        }
        
        System.out.print(maxDegree[N]);
    }
}

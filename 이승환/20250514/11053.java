import java.io.*;
import java.util.*;

//11053
public class Main{
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //수열 초기화
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
    
        //수열길이 배열 초기화
        int len[] = new int[N];
        int result = 0;

        //LIS 알고리즘
        for (int i = N - 1; i>= 0; i--){
            len[i] = 1;

            for (int j = i + 1; j < N; j++){
                if (arr[i] < arr[j]){
                    len[i] = Math.max(len[i], len[j] + 1);
                }
            }
            result = Math.max(result, len[i]);

        }
        System.out.println(result);

    }
}
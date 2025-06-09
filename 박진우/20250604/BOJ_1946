//BOJ_1946 신입사원
//https://www.acmicpc.net/problem/1946

import java.io.*;
import java.util.*;

public class BOJ_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] li = new int[n][2];
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                li[j][0] = Integer.parseInt(st.nextToken());
                li[j][1] = Integer.parseInt(st.nextToken());
            }  

            // 정렬
            Arrays.sort(li, (a, b) -> Integer.compare(a[0], b[0]));
            int count = 1;
            int minInterview = li[0][1];
            for (int j = 1; j < n; j++) {
                if (li[j][1] < minInterview) {
                    count++;
                    minInterview = li[j][1];
                }
            }
            System.out.println(count);
        }
    }
}

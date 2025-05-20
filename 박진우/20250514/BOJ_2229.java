//BOJ_2229_조 짜기
//https://www.acmicpc.net/problem/2229

import java.util.Scanner;

public class BOJ_2229 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int [] li = new int[n+1];
        int [] dp = new int[n+1];

        for(int i = 1; i<=n;i++){
            li[i] = sc.nextInt();
        }
        for(int i = 1; i<=n;i++){
            int max = li[i];
            int min = li[i];

            for(int j = i; j>=1;j--){
                max = Math.max(max,li[j]);
                min = Math.min(min,li[j]);
                dp[i] = Math.max(dp[i], dp[j - 1] + (max - min));
            }
        }
        System.out.println(dp[n]);
    }
}

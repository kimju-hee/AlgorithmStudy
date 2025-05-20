//BOJ_11053_가장 긴 증가하는 부분 수열
//https://www.acmicpc.net/problem/11053

import java.util.Scanner;

public class BOJ_11053 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int [] li = new int[n];
        int [] dp = new int[n];

        for(int i=0 ;i<n;i++){
            li[i]=sc.nextInt();
            dp[i]=1;
        }
        for(int i=1 ;i<n;i++){
            for(int j=0 ;j<i;j++){
                if(li[j]<li[i] && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
        }
        int max = 0;
        for(int i=0 ;i<n;i++){
            if(max<dp[i])max = dp[i];
        }
        System.out.println(max);
    }
}

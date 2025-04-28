//7795.먹을 것인가 먹힐 것인가
//https://www.acmicpc.net/problem/7795

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_7795 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];

            for(int j=0;j<n;j++){
                a[j] = sc.nextInt();
            }
            for(int j=0;j<m;j++){
                b[j] = sc.nextInt();
            }

            Arrays.sort(b);

            int total=0;
            for (int k=0; k<n;k++){
                total+=contLT(b,a[k]);
            }
            sb.append(total).append('\n');
        }
        System.out.println(sb);
    }
//    이진 분류
    private static int contLT(int[] arr, int target){
        int left = 0;
        int right =arr.length;
        while (left<right){
            int mid=(right+left)/2;
            if(arr[mid]<right){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
}

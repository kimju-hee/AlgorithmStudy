//10816.숫자 카드 2
//https://www.acmicpc.net/problem/10816

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10816 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb =new StringBuilder();

        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i =0; i<n;i++){
            a[i]=sc.nextInt();
        }
        Arrays.sort(a);

        int m = sc.nextInt();

        for(int j = 0; j <m; j++){
            int target=sc.nextInt();
            int left = contLT1(a,target);
            int right = contLT2(a,target);
            sb.append(right-left).append(" ");
        }
        System.out.println(sb.toString().trim());
        sc.close();


    }
    private static int contLT1(int[] arr, int target){
        int left = 0;
        int right =arr.length;
        while (left<right){
            int mid=(right+left)/2;
            if(arr[mid]>=target){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    private static int contLT2(int[] arr, int target){
        int left = 0;
        int right =arr.length;
        while (left<right){
            int mid=(right+left)/2;
            if(arr[mid]>target){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}

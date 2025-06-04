//BOJ_20440 니가싫어싫어너무싫어싫어오지마내게찝쩍대지마
//https://www.acmicpc.net/problem/20440

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_20440 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        int max_value = Integer.MIN_VALUE;
        int min_value = Integer.MAX_VALUE;
        int [][] time= new int[n][2];


        for(int a = 0;a<n;a++){
            int te = sc.nextInt();
            int tx = sc.nextInt();

            time[a][0]=te;
            time[a][1]=tx;
            min_value = Math.min(min_value,te);
            max_value = Math.max(max_value,tx);
        }
        int[] arr = new int[max_value+2];
        for(int a = 0;a< n;a++) {
            arr[time[a][0]]+=1;
            arr[time[a][1]]-=1;
        }
        int max = 0;
        int curr = 0;
        int maxstart = 0;
        int maxend = 0;
        boolean inmax = false;

        for (int t = min_value; t <= max_value;t ++){
            curr += arr[t];
            if(curr>max){
                max =curr;
                maxstart =t;
                inmax =true;
            }else if(curr<max&&inmax){
                maxend =t;
                inmax = false;
            }
        }
        if(inmax) maxend=max_value;
        System.out.println(max);
        System.out.println(maxstart+ " " + maxend);
    }
}

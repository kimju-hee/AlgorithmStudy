//BOJ_2167 2차원 배열의 합
//https://www.acmicpc.net/problem/2167

import java.util.Scanner;

public class BOJ_2167 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] li =new int[n][m];
        for(int a=0;a<n;a++){
            for(int b=0;b<m;b++){
                li[a][b]= sc.nextInt();
            }
        }

        int k = sc.nextInt();
        for(int c=0; c <k; c++){
            int i = sc.nextInt()-1;
            int j = sc.nextInt()-1;
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;

            int sum = 0;
            for(int a=i;a<=x;a++){
                for(int b=j;b<=y;b++){
                    sum+=li[a][b];
                }
            }
            System.out.println(sum);
        }
    }
}

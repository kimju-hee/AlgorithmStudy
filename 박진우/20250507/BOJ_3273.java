//BOJ_3273 두 수의 합
//https://www.acmicpc.net/problem/3273

import java.util.Scanner;

public class BOJ_3273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] li = new int[n];
        boolean[] exist = new boolean[2000001];

        for (int a=0;a<n;a++){
            li[a]=sc.nextInt();
            exist[li[a]] = true;
        }
        int x = sc.nextInt();
        int count = 0;

        for(int i = 0; i<n;i++){
            int target = x - li[i];
            exist[li[i]] = false;
            if(target>0 && target<=100000 && exist[target]){
                count++;
            }
        }
        System.out.println(count);
    }
}

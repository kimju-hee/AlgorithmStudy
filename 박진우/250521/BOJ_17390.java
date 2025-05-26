import java.util.Arrays;
import java.util.Scanner;

//BOJ_17390  이건 꼭 풀어야 해!
//https://www.acmicpc.net/problem/17390
public class BOJ_17390 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int n = sc.nextInt();       //수열의 길이
        int q = sc.nextInt();       //질문의 개수
        int [] a = new int[n];

        for(int i = 0;i<n;i++){
            a[i]=sc.nextInt();
        }
        Arrays.sort(a);
        //오름차순 정렬

        for(int i = 0;i<q;i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            int sum =0;
            for(int j = l-1;j<r;j++){
                sum+=a[j];
            }
            System.out.println(sum);
        }
    }
}

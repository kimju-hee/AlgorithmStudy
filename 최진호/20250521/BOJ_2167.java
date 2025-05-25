import java.util.*;

public class BOJ_2167 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for(int j = 1; j <=m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        //누적합 2차원 배열 구하기
        int[][] prefixSum = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                prefixSum[i][j] = arr[i][j] + prefixSum[i-1][j] + prefixSum[i][j-1]-prefixSum[i-1][j-1];
            }
        }
        //---------------
        int k = sc.nextInt();
        sc.nextLine();
        for (int a = 0; a < k; a++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            System.out.println(prefixSum[x][y] - prefixSum[i-1][y] - prefixSum[x][j-1] + prefixSum[i-1][j-1]);
        }
        sc.close();
    }
}

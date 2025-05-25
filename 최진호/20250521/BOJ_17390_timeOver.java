import java.util.*;
public class BOJ_17390_timeOver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int[] prefixSum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = arr[i] + prefixSum[i-1];
        }
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(prefixSum[r]-prefixSum[l-1]);
        }

    }
}

import java.util.*;

public class BOJ_3273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        String[] input = sc.nextLine().split(" ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        int x = sc.nextInt();
        sc.nextLine();
        Arrays.sort(arr); //
        //---------------------------------------------여기까지 입력
        //작동 기작 : 정렬되어 있으므로, 두 합이 목표보다 작으면 P1 ++, 크면 P2--
        int p1 = 0;
        int p2 = n-1;
        int result = 0;

        while(p2>p1){
            int temp = arr[p1] + arr[p2];
            if(temp == x){
                result ++;
                p1++;
            } else if (temp < x) {
                p1++;
            } else {
                p2--;
            }
        }
        System.out.println(result);
        sc.close();
    }
}

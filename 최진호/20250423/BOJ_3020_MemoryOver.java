import java.util.*;

public class BOJ_3020_MemoryOver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input_nh = sc.nextLine().split(" ");
        int n = Integer.parseInt(input_nh[0]);
        int h = Integer.parseInt(input_nh[1]);

        int[] up = new int[n/2];
        int[] down = new int[n/2];

        for(int i = 0; i<n; i++){
            if(i%2==0){
                down[i/2] = Integer.parseInt(sc.nextLine());
            }else{
                up[i/2]= Integer.parseInt(sc.nextLine());
            }
        }

        Arrays.sort(up);
        Arrays.sort(down);

        int minCrash = n; // 최소 충돌 수
        int count = 0;    // 최소 충돌 수를 가진 높이의 개수

        for (int i = 1; i <= h; i++) { // 높이 1부터 h까지
            int crash = 0;
            crash += breakCount(down, i);
            crash += breakCount(up, h - i + 1);

            if (crash < minCrash) {
                minCrash = crash;
                count = 1;
            } else if (crash == minCrash) {
                count++;
            }
        }

        System.out.println(minCrash + " " + count);

        sc.close();
    }
    public static int breakCount (int[] arr, int h){
        int left=0, right = arr.length-1;
        while (left<=right) {
            int mid = (left+right)/2;
            if (arr[mid] >= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr.length - left;
    }
}


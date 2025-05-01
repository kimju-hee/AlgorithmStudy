import java.util.*;

public class BOJ_10816 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] input_n = sc.nextLine().split(" ");
        int m = sc.nextInt();
        sc.nextLine();
        String[] input_m = sc.nextLine().split(" ");
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for(int i=0;i<n;i++){
            arr1[i] = Integer.parseInt(input_n[i]);
        }
        for(int i=0;i<m;i++){
            arr2[i] = Integer.parseInt(input_m[i]);
        }
        //------------------------------------------- 여기까지 선언

        Arrays.sort(arr1); // 이진 탐색을 위한 정렬
        
        StringBuilder sb = new StringBuilder();
        for(int num : arr2){
            sb.append(bi_search_count(arr1, num)).append(" "); // 출력을 위해 이진 탐색 후 Buffer 입력
        }

        System.out.println(sb);
        sc.close(); // 종료
    }
    public static int bi_search_count(int[] arr, int find){
        // 2진 탐색은 2회 실시함.
        // 1회는 왼쪽에서 가장 가까운 Index, 2회는 오른쪽으로 가장 가까운 Index.
        
        // lower bound
        int left = 0;
        int right = arr.length;
        while(left<right){
            int mid = (left + right)/2;
            if(arr[mid]<find){left = mid+1;}
            else{right = mid;}
        }
        int left_idx = left; // 중복 카드의 왼쪽 끝

        // upper bound
        left = 0;
        right = arr.length;
        while(left<right){
            int mid = (left + right)/2;
            if(arr[mid]<=find){left = mid+1;}
            else{right = mid;}
        }
        int right_idx = left; // 중복 카드의 오른쪽 끝. 
        
        return right_idx - left_idx ;// 중복카드의 두 끝의 차 = 카드의 수
    }
}

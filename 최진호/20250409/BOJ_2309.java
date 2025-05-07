import java.util.*;

public class BOJ_2309 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // 리스트 구성 및 리스트 합 추출
        int sum_arr = 0;
        int[] arr = new int[9];
        for(int i=0;i<9;i++){
            arr[i] = sc.nextInt();
            sum_arr += arr[i];
        }
        sc.close();
        
        // 선택정렬 + 범인색출
        boolean find = false;
        int find100;
        int tmp;
        int find_a=101;
        int find_b=101;

        for(int i=0;i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]>arr[j]){ //선택정렬 시도
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
                if(find==false){ //범인을 아직 못찾았다면
                    find100 = sum_arr-(arr[i]+arr[j]);
                    if(find100 == 100){
                        find = true;    // 범인 찾음~
                        find_a = arr[i];
                        find_b = arr[j]; //범인의 value 저장
                    }
                }
            }
        }
        // 범인이 아니면 출력이 안됨
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=find_a&&arr[i]!=find_b){
                System.out.println(arr[i]);
            }
        }
    }
}

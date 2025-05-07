import java.util.*;
public class BOJ_1644 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        // boolean으로 소수 표현
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime,true);
        prime[0] = prime[1] = false;

        //소수배열 구하기 - 에라토스테네스의 체
        for (int i = 2; i*i <= n; i++) {
            if(prime[i]){
                for (int j = i*i; j <= n; j+=i) {
                    prime[j] = false;
                }
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if(prime[i]){
                arr.add(i);
            }
        }
        // 투 포인터 동작원리
        // p2가 끝까지 간경우 끝
        // 구간합의 값이 목표보다 작으면 p2++, 값추가
        // 구간합의 값이 목표보다 크면 p1++, 값빼기
        int result = 0;
        int sum_arr = 0; //구간합
        int p1=0;
        int p2=0;
        while(p2<=arr.size()){
            if(sum_arr==n){
                result++;
                if(p2<arr.size()){//사이즈를 넘지 않았는지 체크
                    sum_arr+=arr.get(p2);
                }
                p2++;

            } else if (sum_arr<n) {
                if(p2<arr.size()){
                    sum_arr+=arr.get(p2);
                }
                p2++;
            }else {
                sum_arr-=arr.get(p1);
                p1++;
            }
        }
        System.out.println(result);
    }
}

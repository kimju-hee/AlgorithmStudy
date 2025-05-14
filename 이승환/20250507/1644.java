import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        int[] primes = onlyPrime(N);
        int sum = 0, count = 0;
        int start = 0, end = 0;

        while (end < primes.length){
            
            if (sum < N) sum += primes[end++];
            else if (sum >= N){
                if (sum == N) count++;
                sum -= primes[start++];   
            }
        }
        System.out.print(count);

    }

    //에라스토테네스의 체
    public static int[] onlyPrime(int n){ 
        // n이하의 소수들을 요소로 가지는 배열을 리턴하는 함수

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        // 소수의 배수 모두 지우기
        for (int i = 2; i <= (int)Math.sqrt(n); i++){
            if (isPrime[i]==false) continue;

            // 중복처리방지를 위해서 j = i * i
            for (int j = i * i; j <= n; j += i){ 
                isPrime[j] = false;
            }
        }

        // 남은 소수의 개수 구하기
        int sum = 0;
        for (boolean b: isPrime) if (b) sum++; 

        // 소수배열 만들기
        int[] arr = new int[sum];
        int index = 0;
        for (int i = 2; i < n + 1; i++){
            if (isPrime[i])arr[index++] = i;
        }
        
        return arr;
    }
}
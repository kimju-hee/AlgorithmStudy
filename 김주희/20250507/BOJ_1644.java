import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] isNotPrime = new boolean[N + 1];
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);
                for (int j = i * 2; j <= N; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        int start = 0, end = 0, sum = 0, count = 0;

        while (true) {
            if (sum >= N) {
                sum -= primes.get(start++);
            } else if (end == primes.size()) {
                break;
            } else {
                sum += primes.get(end++);
            }

            if (sum == N) {
                count++;
            }
        }

        System.out.println(count);
    }
}

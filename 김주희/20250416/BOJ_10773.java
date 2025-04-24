import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10773 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int K = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int temp = Integer.parseInt(st.nextToken());
            if (temp == 0) {
                stack.pop();
            } else {
                stack.push(temp);
            }
        }
        int answer = 0;

        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        System.out.println(answer);
    }
}

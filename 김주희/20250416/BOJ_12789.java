import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1;
        int idx = 0;
        Stack<Integer> stack = new Stack<>();

        while (idx < N) {
            if (list[idx] == start) {
                start++;
            } else if (!stack.isEmpty() && stack.peek() == start) {
                stack.pop();
                start++;
                continue;
            } else {
                stack.push(list[idx]);
            }
            idx++;
        }

        while (!stack.isEmpty() && stack.peek() == start) {
            stack.pop();
            start++;
        }

        if (stack.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}

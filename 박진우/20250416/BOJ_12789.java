import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.add(sc.nextInt());
        }
        Stack<Integer> stack = new Stack<>();
        int current = 1;

        while (!queue.isEmpty() || (!stack.isEmpty() && stack.peek() == current)) {
            if (!queue.isEmpty() && queue.peek() == current) {
                queue.poll();
                current++;
            } else if (!stack.isEmpty() && stack.peek() == current) {
                stack.pop();
                current++;
            } else if (!queue.isEmpty()) {
                stack.push(queue.poll());
            }
        }

        if (current == N + 1) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}

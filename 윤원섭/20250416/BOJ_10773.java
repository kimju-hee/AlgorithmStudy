import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        Stack<Integer> stack = new Stack<>();     // 스택 생성

        // 입력된 수만큼 반복
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();     // 입력 수를 받음

            if (m == 0) {     // 0이 입력되면 직전에 추가된 수 스택에서 제거
                stack.pop();
            } else {     // 0이 아닌 경우 스택에 추가
                stack.add(m);
            }
        }

        // 스택이 빌 때까지 모든 수를 더함
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        System.out.println(sum);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 계산한 결과 저장할 3차원 배열
    static int[][][] arr = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            // 입력 문자열을 공백 기준으로 나눔
            String[] inputs = reader.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            int c = Integer.parseInt(inputs[2]);

            // -1 -1 -1 입력 시 종료
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            int result = w(a, b, c);
            System.out.printf("w(%d, %d, %d) = %d%n", a, b, c, result);
        }
    }

    // 재귀 함수
    static int w(int a, int b, int c) {
        // a, b, c 중 하나라도 0 이하이면 1 반환
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        // 20보다 큰 값은 모두 20으로 처리
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        // 이미 계산된 값이 있으면 다시 계산하지 않고 바로 반환
        if (arr[a][b][c] != 0) {
            return arr[a][b][c];
        }

        // a < b < c 조건일 경우
        if (a < b && b < c) {
            arr[a][b][c] = w(a, b, c - 1)
                          + w(a, b - 1, c - 1)
                          - w(a, b - 1, c);
        } else {
            arr[a][b][c] = w(a - 1, b, c)
                          + w(a - 1, b - 1, c)
                          + w(a - 1, b, c - 1)
                          - w(a - 1, b - 1, c - 1);
        }
        return arr[a][b][c];
    }
}

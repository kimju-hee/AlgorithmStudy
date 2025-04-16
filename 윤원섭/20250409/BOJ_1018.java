import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken()); // 행 개수
        int col = Integer.parseInt(st.nextToken()); // 열 개수

        char[][] board = new char[row][col];

        // 체스판 정보 입력
        for (int i = 0; i < row; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int min = Integer.MAX_VALUE;

        // 가능한 모든 8x8 보드 위치 탐색
        for (int x = 0; x <= row - 8; x++) { // 체스판이 시작될 수 있는 행 위치
            for (int y = 0; y <= col - 8; y++) { // 체스판이 시작될 수 있는 열 위치
                int white = 0;

                // 8x8 크기의 체스판 검사
                for (int i = x; i < x + 8; i++) {
                    for (int j = y; j < y + 8; j++) {
                        // W로 시작하는 체스판 기준
                        if ((i + j) % 2 == 1 && board[i][j] == 'W') {
                            white++;
                        } else if ((i + j) % 2 == 0 && board[i][j] == 'B') {
                            white++;
                        }
                    }
                }
                min = Math.min(min, Math.min(white, 64 - white));
            }
        }
        System.out.println(min);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];

        for (int i = 0 ; i < N; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int repaint = countRepaint(board, i, j);
                min = Math.min(min, repaint);
            }
        }

        System.out.println(min);

    }

    public static int countRepaint(char[][] board, int x, int y) {
        int repaintW = 0; // 왼쪽 위가 W일 경우
        int repaintB = 0; // 왼쪽 위가 B일 경우

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                char W = ((i + j) % 2 == 0) ? 'W' : 'B';
                char B = ((i + j) % 2 == 0) ? 'B' : 'W';

                if (board[i][j] != W) {
                    repaintW ++;
                }
                if (board[i][j] != B) {
                    repaintB ++;
                }
            }
        }
        return Math.min(repaintB, repaintW);
    }
}

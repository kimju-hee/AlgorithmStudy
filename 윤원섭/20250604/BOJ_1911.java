import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int L = Integer.parseInt(firstLine[1]);

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(line[0]);
            arr[i][1] = Integer.parseInt(line[1]);
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int boardEnd = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            int start = arr[i][0];
            int end = arr[i][1];

            if (start < boardEnd) start = boardEnd;

            int cover = end - start;
            if (cover <= 0) continue;

            int need = (cover + L - 1) / L; // 올림 계산
            count += need;
            boardEnd = start + need * L;
        }
        System.out.println(count);
    }
}

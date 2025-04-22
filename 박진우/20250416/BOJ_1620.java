import java.io.*;
import java.util.*;

public class BOJ_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 이름 -> 번호
        HashMap<String, Integer> nameToNum = new HashMap<>();
        // 번호 -> 이름
        String[] numToName = new String[N + 1];

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameToNum.put(name, i);
            numToName[i] = name;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String quiz = br.readLine();
            if (isNumber(quiz)) {
                // 숫자면 번호->이름
                int num = Integer.parseInt(quiz);
                sb.append(numToName[num]).append("\n");
            } else {
                // 이름이면 이름->번호
                sb.append(nameToNum.get(quiz)).append("\n");
            }
        }
        System.out.print(sb);
    }

    private static boolean isNumber(String s) {
        return s.charAt(0) >= '0' && s.charAt(0) <= '9';
    }
}


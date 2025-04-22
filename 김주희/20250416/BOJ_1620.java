import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1620 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int M = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            String name = st.nextToken();
            int idx = i+1;
            map.put(name, idx);
            map2.put(idx, name);
        }

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            String line = st.nextToken();

            if (line.matches("\\d+")) {
                System.out.println(map2.get(Integer.parseInt(line)));
            } else {
                System.out.println(map.get(line));
            }
        }
    }
}

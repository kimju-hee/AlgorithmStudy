import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> lis = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            // arr[i]가 lis에서 들어갈 위치 찾기 (lower bound)
            int index = lowerBound(lis, arr[i]);

            // lis의 마지막 값보다 크면 추가, 아니면 교체
            if (index == lis.size()) {
                lis.add(arr[i]);
            } else {
                lis.set(index, arr[i]);
            }
        }

        System.out.println(lis.size());
    }

    public static int lowerBound(ArrayList<Integer> arr, int target) {
        int left = 0;
        int right = arr.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (target <= arr.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}

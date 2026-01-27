package Experiment3;

import java.util.*;

public class StableAttendanceWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: number of records
        int N = sc.nextInt();

        // Input: attendance records
        char[] arr = new char[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.next().charAt(0);
        }

        // HashMap acts like unordered_map
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        // Important initialization
        map.put(0, -1);

        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P') {
                sum += 1;
            } else { // 'A'
                sum -= 1;
            }

            // If sum already seen
            if (map.containsKey(sum)) {
                int prevIndex = map.get(sum);
                maxLen = Math.max(maxLen, i - prevIndex);
            } else {
                // Store first occurrence
                map.put(sum, i);
            }
        }

        System.out.println(maxLen);
    }
}

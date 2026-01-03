import java.util.*;

public class deadlock_detection {

    static int n = 3; // jumlah proses
    static int[] allocation = {0, 1, 2}; // resource yang dipegang
    static int[] request = {1, 2, 0};    // resource yang diminta

    static boolean[] visited = new boolean[n];
    static boolean[] stack = new boolean[n];

    public static void main(String[] args) {
        boolean deadlock = false;

        for (int i = 0; i < n; i++) {
            if (detectCycle(i)) {
                deadlock = true;
                break;
            }
        }

        if (deadlock) {
            System.out.println("⚠ SISTEM MENGALAMI DEADLOCK");
            System.out.println("Proses yang terlibat deadlock:");

            for (int i = 0; i < n; i++) {
                if (stack[i]) {
                    System.out.println("P" + (i + 1));
                }
            }
        } else {
            System.out.println("✅ SISTEM AMAN (TIDAK DEADLOCK)");
        }
    }

    static boolean detectCycle(int p) {
        if (stack[p]) return true;
        if (visited[p]) return false;

        visited[p] = true;
        stack[p] = true;

        for (int i = 0; i < n; i++) {
            if (allocation[i] == request[p]) {
                if (detectCycle(i)) return true;
            }
        }

        stack[p] = false;
        return false;
    }
}

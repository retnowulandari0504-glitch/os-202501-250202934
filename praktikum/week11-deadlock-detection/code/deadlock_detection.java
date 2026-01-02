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

        if

import java.util.*;

public class DeadlockDetection {

    public static void main(String[] args) {

        String[] processes = {"P1", "P2", "P3"};

        Map<String, String> allocation = new HashMap<>();
        allocation.put("P1", "R1");
        allocation.put("P2", "R2");
        allocation.put("P3", "R3");

        Map<String, String> request = new HashMap<>();
        request.put("P1", "R2");
        request.put("P2", "R3");
        request.put("P3", "R1");

        Map<String, String> waitFor = new HashMap<>();

        for (String p1 : processes) {
            for (String p2 : processes) {
                if (!p1.equals(p2)) {
                    if (request.get(p1).equals(allocation.get(p2))) {
                        waitFor.put(p1, p2);
                    }
                }
            }
        }

        Set<String> visited = new HashSet<>();
        Set<String> stack = new HashSet<>();

        boolean deadlock = false;
        for (String p : processes) {
            if (detectCycle(p, waitFor, visited, stack)) {
                deadlock = true;
                break;
            }
        }

        if (deadlock) {
            System.out.println("DEADLOCK TERDETEKSI!");
            System.out.println("Proses yang terlibat:");
            for (String p : stack) {
                System.out.println("- " + p);
            }
        } else {
            System.out.println("Sistem AMAN (tidak deadlock).");
        }
    }

    private static boolean detectCycle(String process,
                                       Map<String, String> graph,
                                       Set<String> visited,
                                       Set<String> stack) {

        if (stack.contains(process)) {
            return true;
        }

        if (visited.contains(process)) {
            return false;
        }

        visited.add(process);
        stack.add(process);

        String next = graph.get(process);
        if (next != null) {
            return detectCycle(next, graph, visited, stack);
        }

        stack.remove(process);
        return false;
    }
}

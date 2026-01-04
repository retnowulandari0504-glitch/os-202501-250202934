import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class deadlock_detection {

    public static void main(String[] args) {

        String fileName = "dataset_deadlock.csv";

        // Menyimpan data allocation dan request
        Map<String, String> allocation = new HashMap<>();
        Map<String, String> request = new HashMap<>();
        List<String> processes = new ArrayList<>();

        // ===== 1. MEMBACA DATA PROSES & RESOURCE =====
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine(); // lewati header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String process = data[0];
                String alloc = data[1];
                String req = data[2];

                processes.add(process);
                allocation.put(process, alloc);
                request.put(process, req);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca file dataset!");
            return;
        }

        // ===== 2. MEMBANGUN WAIT-FOR GRAPH =====
        Map<String, List<String>> waitForGraph = new HashMap<>();

        for (String p1 : processes) {
            waitForGraph.put(p1, new ArrayList<>());
            for (String p2 : processes) {
                if (!p1.equals(p2)) {
                    if (request.get(p1).equals(allocation.get(p2))) {
                        waitForGraph.get(p1).add(p2);
                    }
                }
            }
        }

        // ===== 3. DETEKSI DEADLOCK =====
        Set<String> visited = new HashSet<>();
        Set<String> stack = new HashSet<>();
        Set<String> deadlockProcesses = new HashSet<>();

        for (String process : processes) {
            if (!visited.contains(process)) {
                dfs(process, waitForGraph, visited, stack, deadlockProcesses);
            }
        }

        // ===== 4. OUTPUT =====
        if (!deadlockProcesses.isEmpty()) {
            System.out.println("Sistem dalam keadaan deadlock!");
            System.out.println("Proses yang terlibat:");
            for (String p : deadlockProcesses) {
                System.out.println(p);
            }
        } else {
            System.out.println("Tidak terjadi deadlock.");
        }
    }

    // DFS untuk mendeteksi cycle
    private static boolean dfs(
            String process,
            Map<String, List<String>> graph,
            Set<String> visited,
            Set<String> stack,
            Set<String> deadlockProcesses) {

        visited.add(process);
        stack.add(process);

        for (String neighbor : graph.get(process)) {
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, graph, visited, stack, deadlockProcesses)) {
                    deadlockProcesses.add(process);
                    return true;
                }
            } else if (stack.contains(neighbor)) {
                deadlockProcesses.add(process);
                deadlockProcesses.add(neighbor);
                return true;
            }
        }

        stack.remove(process);
        return false;
    }
}

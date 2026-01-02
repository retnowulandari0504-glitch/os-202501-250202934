import java.io.*;
import java.util.*;

public class deadlock_detection {

    static Map<String, List<String>> graph = new HashMap<>();
    static Set<String> visited = new HashSet<>();
    static Set<String> stack = new HashSet<>();
    static boolean deadlock = false;

    public static void main(String[] args) {
        String file = "dataset_deadlock.csv";

        loadCSV(file);

        for (String process : graph.keySet()) {
            if (!visited.contains(process)) {
                dfs(process);
            }
        }

        if (deadlock) {
            System.out.println("❌ DEADLOCK TERDETEKSI!");
        } else {
            System.out.println("✅ TIDAK ADA DEADLOCK");
        }
    }

    static void loadCSV(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                graph.putIfAbsent(data[0], new ArrayList<>());
                graph.get(data[0]).add(data[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void dfs(String process) {
        visited.add(process);
        stack.add(process);

        for (String neighbor : graph.getOrDefault(process, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor);
            } else if (stack.contains(neighbor)) {
                deadlock = true;
            }
        }
        stack.remove(process);
    }
}

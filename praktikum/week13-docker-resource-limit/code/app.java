import java.util.ArrayList;
import java.util.List;

public class app {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Program Uji Docker Resource Limit (Java) ===");

        // Uji CPU
        new Thread(() -> {
            long counter = 0;
            while (true) {
                counter++;
                if (counter % 100_000_000 == 0) {
                    System.out.println("CPU aktif, counter = " + counter);
                }
            }
        }).start();

        // Uji Memory
        List<byte[]> memory = new ArrayList<>();
        int i = 0;
        while (true) {
            memory.add(new byte[10 * 1024 * 1024]); // 10 MB
            i++;
            System.out.println("Alokasi memori ke-" + i + " (~" + (i * 10) + " MB)");
            Thread.sleep(1000);
        }
    }
}
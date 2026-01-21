import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FCFS {

    static class Process {
        String id;
        int arrivalTime;
        int burstTime;
        int waitingTime;
        int turnaroundTime;

        Process(String id, int arrivalTime, int burstTime) {
            this.id = id;
            this.arrivalTime = arrivalTime;
            this.burstTime = burstTime;
        }
    }

    public static void run() {
        ArrayList<Process> processes = new ArrayList<>();

        try {
            File file = new File("data/proses.csv");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                processes.add(new Process(
                        data[0],
                        Integer.parseInt(data[1]),
                        Integer.parseInt(data[2])
                ));
            }
            sc.close();

        } catch (Exception e) {
            System.out.println("Gagal baca data/proses.csv");
            return;
        }

        int currentTime = 0;
        double totalWT = 0, totalTAT = 0;

        System.out.println("\n=== HASIL FCFS ===");
        System.out.println("Proses | AT | BT | WT | TAT");
        System.out.println("-----------------------------");

        for (Process p : processes) {
            if (currentTime < p.arrivalTime) {
                currentTime = p.arrivalTime;
            }

            p.waitingTime = currentTime - p.arrivalTime;
            p.turnaroundTime = p.waitingTime + p.burstTime;

            currentTime += p.burstTime;

            totalWT += p.waitingTime;
            totalTAT += p.turnaroundTime;

            System.out.printf(
                "%5s | %2d | %2d | %2d | %3d\n",
                p.id, p.arrivalTime, p.burstTime,
                p.waitingTime, p.turnaroundTime
            );
        }

        System.out.println("-----------------------------");
        System.out.printf("Rata-rata WT  : %.2f\n", totalWT / processes.size());
        System.out.printf("Rata-rata TAT : %.2f\n", totalTAT / processes.size());
    }
}
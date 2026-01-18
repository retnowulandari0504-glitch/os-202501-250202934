import java.util.*;

class Process {
    String name;
    int arrivalTime;
    int burstTime;
    int completionTime;
    int turnaroundTime;
    int waitingTime;
    boolean finished = false;

    Process(String name, int arrivalTime, int burstTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}

public class SJF {
    public static void main(String[] args) {

        List<Process> processes = new ArrayList<>();

        processes.add(new Process("P1", 0, 8));
        processes.add(new Process("P2", 1, 4));
        processes.add(new Process("P3", 2, 9));
        processes.add(new Process("P4", 3, 5));

        int currentTime = 0;
        int completed = 0;
        int n = processes.size();

        while (completed < n) {

            Process shortest = null;

            // Cari proses yang sudah datang & burst terkecil
            for (Process p : processes) {
                if (!p.finished && p.arrivalTime <= currentTime) {
                    if (shortest == null || p.burstTime < shortest.burstTime) {
                        shortest = p;
                    }
                }
            }

            // Jika belum ada proses yang datang
            if (shortest == null) {
                currentTime++;
                continue;
            }

            // Eksekusi proses terpilih
            currentTime += shortest.burstTime;
            shortest.completionTime = currentTime;
            shortest.turnaroundTime =
                    shortest.completionTime - shortest.arrivalTime;
            shortest.waitingTime =
                    shortest.turnaroundTime - shortest.burstTime;
            shortest.finished = true;
            completed++;
        }

        // Output
        System.out.println("SJF Non-Preemptive Scheduling");
        System.out.println("Proses\tAT\tBT\tWT\tTAT");

        for (Process p : processes) {
            System.out.println(
                p.name + "\t" +
                p.arrivalTime + "\t" +
                p.burstTime + "\t" +
                p.waitingTime + "\t" +
                p.turnaroundTime
            );
        }
    }
}
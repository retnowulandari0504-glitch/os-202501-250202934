import java.io.*;
import java.util.*;

class Process {
    String id;
    int arrivalTime;
    int burstTime;
    int startTime;
    int finishTime;
    int waitingTime;
    int turnaroundTime;

    Process(String id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}

public class Scheduling_Simulation_Java {

    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();

        // Membaca dataset.csv
        try {
            BufferedReader br = new BufferedReader(new FileReader("dataset.csv"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                processes.add(new Process(
                        data[0],
                        Integer.parseInt(data[1]),
                        Integer.parseInt(data[2])
                ));
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Gagal membaca dataset.csv");
            return;
        }

        // Urutkan berdasarkan arrival time (FCFS)
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));

        int currentTime = 0;
        double totalWaiting = 0;
        double totalTurnaround = 0;

        System.out.println(" FCFS Scheduling Simulation ");
        System.out.println("Process | Arrival | Burst | Start | Finish | Waiting | Turnaround");
        System.out.println("-------------------------------------------------------------------");

        for (Process p : processes) {
            if (currentTime < p.arrivalTime) {
                currentTime = p.arrivalTime;
            }

            p.startTime = currentTime;
            p.finishTime = p.startTime + p.burstTime;
            p.waitingTime = p.startTime - p.arrivalTime;
            p.turnaroundTime = p.finishTime - p.arrivalTime;

            currentTime = p.finishTime;

            totalWaiting += p.waitingTime;
            totalTurnaround += p.turnaroundTime;

            System.out.printf("%7s | %7d | %5d | %5d | %6d | %7d | %10d%n",
                    p.id, p.arrivalTime, p.burstTime,
                    p.startTime, p.finishTime,
                    p.waitingTime, p.turnaroundTime);
        }

        System.out.println("-------------------------------------------------------------------");
        System.out.printf("Average Waiting Time    : %.2f%n", totalWaiting / processes.size());
        System.out.printf("Average Turnaround Time : %.2f%n", totalTurnaround / processes.size());
    }
}

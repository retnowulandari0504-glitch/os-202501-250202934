class Process {
    String name;
    int arrivalTime;
    int burstTime;
    int completionTime;
    int turnaroundTime;
    int waitingTime;

    Process(String name, int arrivalTime, int burstTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}

public class FCFS {
    public static void main(String[] args) {

        Process[] processes = {
            new Process("P1", 0, 8),
            new Process("P2", 1, 4),
            new Process("P3", 2, 9),
            new Process("P4", 3, 5)
        };

        int currentTime = 0;

        for (Process p : processes) {

            // Jika CPU idle, lompat ke arrival time proses
            if (currentTime < p.arrivalTime) {
                currentTime = p.arrivalTime;
            }

            // Completion Time
            currentTime += p.burstTime;
            p.completionTime = currentTime;

            // Turnaround Time
            p.turnaroundTime = p.completionTime - p.arrivalTime;

            // Waiting Time
            p.waitingTime = p.turnaroundTime - p.burstTime;
        }

        // Output
        System.out.println("FCFS Scheduling");
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
import java.util.Scanner;

public class FCFS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah proses: ");
        int n = input.nextInt();

        int[] at = new int[n]; // Arrival Time
        int[] bt = new int[n]; // Burst Time
        int[] wt = new int[n]; // Waiting Time
        int[] tat = new int[n]; // Turnaround Time

        // Input data proses
        for (int i = 0; i < n; i++) {
            System.out.println("\nProses P" + (i + 1));
            System.out.print("Arrival Time: ");
            at[i] = input.nextInt();
            System.out.print("Burst Time: ");
            bt[i] = input.nextInt();
        }

        // Proses FCFS
        wt[0] = 0;
        tat[0] = bt[0];

        for (int i = 1; i < n; i++) {
            wt[i] = tat[i - 1] - at[i];
            if (wt[i] < 0) {
                wt[i] = 0;
            }
            tat[i] = wt[i] + bt[i];
        }

        // Output
        System.out.println("Hasil Perhitungan FCFS");
        System.out.println("-------------------------------------------------");
        System.out.println("Proses\tAT\tBT\tWT\tTAT");
        System.out.println("-------------------------------------------------");

        int totalWT = 0, totalTAT = 0;

        for (int i = 0; i < n; i++) {
            totalWT += wt[i];
            totalTAT += tat[i];
            System.out.println("P" + (i + 1) + "\t" + at[i] + "\t" + bt[i] + "\t" + wt[i] + "\t" + tat[i]);
        }

        System.out.println("-------------------------------------------------");
        System.out.println("Rata-rata Waiting Time = " + (float) totalWT / n);
        System.out.println("Rata-rata Turnaround Time = " + (float) totalTAT / n);
    }
}

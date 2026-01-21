import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("[ MINI SIMULASI OS ]");
        System.out.println("1. Page Replacement (FIFO)");
        System.out.println("2. Keluar");
        System.out.print("Pilih menu: ");

        int pilihan = input.nextInt();

        switch (pilihan) {
            case 1:
                FIFO.run(3);   // ← PANGGIL FIFO
                break;
            case 2:
                System.out.println("Program selesai.");
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }
}
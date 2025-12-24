import java.util.*;

public class page_replacement {

    static int[] reference = {7,0,1,2,0,3,0,4,2,3,0,3,2};
    static int frameSize = 3;

    public static void main(String[] args) {
        fifo();
        System.out.println("\n-----------------------------\n");
        lru();
    }

    // ================= FIFO =================
    static void fifo() {
        Set<Integer> frames = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int fault = 0;

        System.out.println("FIFO Page Replacement\n");

        for (int page : reference) {
            if (!frames.contains(page)) {
                fault++;

                if (frames.size() == frameSize) {
                    int removed = queue.poll();
                    frames.remove(removed);
                }

                frames.add(page);
                queue.add(page);
                System.out.println("Page " + page + " => FAULT " + frames);
            } else {
                System.out.println("Page " + page + " => HIT   " + frames);
            }
        }

        System.out.println("\nTotal Page Fault FIFO: " + fault);
    }

    // ================= LRU =================
    static void lru() {
        List<Integer> frames = new ArrayList<>();
        int fault = 0;

        System.out.println("LRU Page Replacement\n");

        for (int page : reference) {
            if (!frames.contains(page)) {
                fault++;

                if (frames.size() == frameSize) {
                    frames.remove(0); // hapus paling lama dipakai
                }
            } else {
                frames.remove((Integer) page);
            }

            frames.add(page);
            System.out.println("Page " + page + " => " +
                    (frames.contains(page) && frames.size() <= frameSize ? "HIT   " : "FAULT ") + frames);
        }

        System.out.println("\nTotal Page Fault LRU: " + fault);
    }
}

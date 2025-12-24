import java.util.*;

public class page_replacement.java {
    public static void main(String[] args) {
        int[] reference = {7,0,1,2,0,3,0,4,2,3,0,3,2};
        int frameSize = 3;

        Set<Integer> frames = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        int pageFault = 0;

        System.out.println("Simulasi FIFO page replacement\n");

        for (int page : reference) {
            if (!frames.contains(page)) {
                pageFault++;

                if (frames.size() == frameSize) {
                    int removed = queue.poll();
                    frames.remove(removed);
                }

                frames.add(page);
                queue.add(page);
                System.out.println("Page " + page + " → FAULT " + frames);
            } else {
                System.out.println("Page " + page + " → HIT   " + frames);
            }
        }

        System.out.println("\nTotal Page Fault: " + pageFault);
    }
}

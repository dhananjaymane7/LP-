import java.util.*;

public class Fifo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter size of pagereferences:");
        int m = sc.nextInt();
        int frameCount = 3;
        int pageReference[] = new int[m];
        System.out.println("\nEnter page references:");
        for (int i = 0; i < m; i++) {
            pageReference[i] = sc.nextInt();
        }

        int pageFaults = FIFO(pageReference, frameCount);
        System.out.println("\nPage faults are:" + pageFaults);

    }

    public static int FIFO(int pageReference[], int frameCount) {

        Queue<Integer> frameQueue = new LinkedList<>();
        int pageFaults = 0;

        for (int page : pageReference) {
            if (!frameQueue.contains(page)) {
                if (frameQueue.size() == frameCount) {
                    int removedPage = frameQueue.poll();
                    System.out.println("\nRemoved page is :" + removedPage);
                }

                frameQueue.offer(page);
                System.out.println("\nPage added in the queue :" + page);
                pageFaults++;
            } else {
                System.out.println("\nPage already in the queue");
            }
        }
        return pageFaults;
    }

}
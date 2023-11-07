import java.util.*;

public class Lru {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter total no of pagereferences:");
        int n = sc.nextInt();
        int pageReference[] = new int[n];
        int frameCount = 3;

        System.out.println("\nEnter pagereferences :");
        for (int i = 0; i < n; i++) {
            pageReference[i] = sc.nextInt();
        }

        int pageFaults = LRU(pageReference, frameCount);
        System.out.println("Total pagefaults are :" + pageFaults);
    }

    public static int LRU(int pageReference[], int frameCount) {
        Map<Integer, Integer> frameQueue = new LinkedHashMap<>(frameCount, 0.75f, true);
        int pageFaults = 0;

        for (int page : pageReference) {
            if (!frameQueue.containsKey(page)) {
                if (frameQueue.size() >= frameCount) {
                    int removedPage = frameQueue.entrySet().iterator().next().getKey();
                    frameQueue.remove(removedPage);
                    System.out.println("\nRemoved page is :" + removedPage);

                }
                frameQueue.put(page, 1);
                pageFaults++;
            } else {
                System.out.println("\n page already in the queue");
            }
            System.out.println("Page " + page + " is in frame:" + frameQueue.keySet());
        }
        return pageFaults;
    }
}
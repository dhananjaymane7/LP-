import java.util.LinkedList;
import java.util.Queue;

public class opl {
    public static void main(String[] args) {
        int[] pageReferences = { 1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5 };
        int numFrames = 3; // Number of frames available in memory

        int pageFaults = 0;
        Queue<Integer> frameQueue = new LinkedList<>();

        for (int page : pageReferences) {
            if (!frameQueue.contains(page)) {
                if (frameQueue.size() < numFrames) {
                    frameQueue.offer(page);
                } else {
                    int farthestPage = -1;
                    int farthestDistance = -1;
                    for (int frame : frameQueue) {
                        int futureDistance = indexOfNextReference(pageReferences, frameQueue, frame);
                        if (futureDistance == -1) {
                            farthestPage = frame;
                            break;
                        }
                        if (futureDistance > farthestDistance) {
                            farthestPage = frame;
                            farthestDistance = futureDistance;
                        }
                    }
                    frameQueue.remove(farthestPage);
                    frameQueue.offer(page);
                }
                pageFaults++;
            }
            System.out.println("Page References: " + page + ", Page Frames: " + frameQueue);
        }

        System.out.println("Total Page Faults: " + pageFaults);
    }

    // Helper method to find the index of the next reference to a page
    private static int indexOfNextReference(int[] pageReferences, Queue<Integer> frameQueue, int page) {
        for (int i = 0; i < pageReferences.length; i++) {
            if (pageReferences[i] == page && !frameQueue.contains(page)) {
                return i;
            }
        }
        return -1;
    }
}

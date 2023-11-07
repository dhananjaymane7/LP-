import java.util.*;

public class worst_fit {
    public static void WorstFit(int blockSize[], int processSize[]) {
        int m = blockSize.length;
        int n = processSize.length;
        int allocation[] = new int[n];

        for (int i = 0; i < n; i++) {
            allocation[i] = -1;
            int WorstIndex = -1;

            for (int j = 0; j < m; j++) {
                if (blockSize[j] > processSize[i]) {
                    if (WorstIndex == -1 || blockSize[j] > blockSize[WorstIndex]) {
                        WorstIndex = j;
                    }
                }
            }

            if (WorstIndex != -1) {
                allocation[i] = WorstIndex;
                blockSize[WorstIndex] -= processSize[i];
            }
        }
        System.out.println("\nProcess \t\tProcess Size \t\tBlock Size");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + (i + 1) + "\t\t" + processSize[i] + "\t\t");
            if (allocation[i] != -1) {
                System.out.println(allocation[i] + 1);
            } else {
                System.out.println("\nNot allocated");
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of memory blocks: ");
        int m = sc.nextInt();
        int[] blockSize = new int[m];

        System.out.println("Enter block sizes:");
        for (int i = 0; i < m; i++) {
            blockSize[i] = sc.nextInt();
        }

        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();
        int[] processSize = new int[n];

        System.out.println("Enter process sizes:");
        for (int i = 0; i < n; i++) {
            processSize[i] = sc.nextInt();
        }

        WorstFit(blockSize, processSize);
    }
}
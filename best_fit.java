import java.util.Scanner;

public class best_fit {
    public static void bestFit(int[] blockSize, int[] processSize) {
        int m = blockSize.length;
        int n = processSize.length;
        int[] allocation = new int[n];

        for (int i = 0; i < n; i++) {
            allocation[i] = -1;
            int bestIndex = -1;

            for (int j = 0; j < m; j++) {
                if (blockSize[j] >= processSize[i] && (bestIndex == -1 || blockSize[j] < blockSize[bestIndex])) {
                    bestIndex = j;
                }
            }

            if (bestIndex != -1) {
                allocation[i] = bestIndex;
                blockSize[bestIndex] -= processSize[i];
            }
        }

        System.out.println("\nProcess \t\t Process Size \t\tBlock size");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + (i + 1) + "\t\t" + processSize[i] + "\t\t");
            if (allocation[i] != -1) {
                System.out.println(allocation[i] + 1);
            } else {
                System.out.println("\nnot alloted");
            }
            System.out.println();
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

        bestFit(blockSize, processSize);
    }
}

import java.util.Scanner;

public class next_fit {
    public static void nextFit(int[] blockSize, int[] processSize) {
        int m = blockSize.length;
        int n = processSize.length;
        int[] allocation = new int[n];
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {
            allocation[i] = -1;

            for (int j = 0; j < m; j++) {
                if (blockSize[j] >= processSize[i]) {
                    allocation[i] = j;
                    blockSize[j] -= processSize[i];
                    lastIndex = j;
                    break;
                }
            }
        }

        System.out.println("\nProcess No. \tProcess Size \tBlock No.");
        for (int i = 0; i < n; i++) {
            System.out.print("   " + (i + 1) + "\t\t" + processSize[i] + "\t\t");
            if (allocation[i] != -1)
                System.out.print(allocation[i] + 1);
            else
                System.out.print("Not Allocated");
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

        nextFit(blockSize, processSize);
    }
}

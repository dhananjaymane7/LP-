import java.util.Scanner;

public class RoundRobin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of processes (max 10): ");
        int n = sc.nextInt();
        int[] bt = new int[n];
        int[] rem = new int[n]; // remaining burst time
        int[] wt = new int[n];
        int[] tt = new int[n];

        System.out.println("Enter burst times of the processes:");
        for (int i = 0; i < n; i++) {
            System.out.print("P" + i + ": ");
            bt[i] = sc.nextInt();
            rem[i] = bt[i];
        }

        System.out.print("Enter time quantum: ");
        int quantum = sc.nextInt();
        int time = 0;

        while (true) {
            boolean allCompleted = true;
            for (int i = 0; i < n; i++) {
                if (rem[i] > 0) {
                    allCompleted = false;
                    int runTime = Math.min(quantum, rem[i]);
                    time += runTime;
                    rem[i] -= runTime;
                    if (rem[i] == 0) {
                        wt[i] = time - bt[i];
                        tt[i] = wt[i] + bt[i];
                    }
                }
            }
            if (allCompleted) {
                break;
            }
        }

        double awt = 0;
        double att = 0;

        System.out.println("Process\tBurst Time\tWaiting Time\tTurnaround Time");
        for (int i = 0; i < n; i++) {
            awt += wt[i];
            att += tt[i];
            System.out.println("P" + (i + 1) + "\t" + bt[i] + "\t\t" + wt[i] + "\t\t" + tt[i]);
        }

        awt /= n;
        att /= n;

        System.out.println("\nAverage Waiting Time: " + awt);
        System.out.println("Average Turnaround Time: " + att);
        sc.close();
    }
}

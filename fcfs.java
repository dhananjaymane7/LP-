import java.util.Scanner;

public class fcfs {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes:");
        int n = sc.nextInt();
        int bt[] = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the burst time for process " + (i + 1) + ":");
            bt[i] = sc.nextInt();
        }

        int wt[] = new int[n];
        int tt[] = new int[n];

        wt[0] = 0;
        tt[0] = bt[0];

        for (int i = 1; i < n; i++) {
            wt[i] = wt[i - 1] + bt[i - 1];
            tt[i] = wt[i] + bt[i];
        }

        System.out.println("\nProcesses || Burst Time || Waiting Time || Turn-Around Time");
        float awt = 0;
        float att = 0;

        for (int i = 0; i < n; i++) {
            awt += wt[i];
            att += tt[i];
            System.out.println(i + 1 + "\t  ||\t" + bt[i] + "\t||\t" + wt[i] + "\t||\t " + tt[i]);
        }

        awt /= n;
        att /= n;

        System.out.println("\nAverage waiting time = " + awt);
        System.out.println("Average turn around time = " + att);
    }
}
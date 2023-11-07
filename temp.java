import java.util.*;

public class temp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter total no.of process :  ");
        int n = sc.nextInt();
        int bt[] = new int[n];
        int tt[] = new int[n];
        int wt[] = new int[n];
        int rem[] = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nenter burst time for process :" + (i + 1));
            bt[i] = sc.nextInt();
            rem[i] = bt[i];
        }

        System.out.println("\nEnter quantum time :");
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

        System.out.println("process ||burst time ||waiting time || turnaround time");
        float awt = 0;
        float att = 0;
        for (int i = 0; i < n; i++) {
            awt += wt[i];
            att += tt[i];
            System.out.println(" " + (i + 1) + "\t\t" + bt[i] + "\t\t" + wt[i] + "\t\t" + tt[i]);
        }
        awt /= n;
        att /= n;
        System.out.println(awt);
        System.out.println(att);
    }
}
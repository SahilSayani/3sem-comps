package Lab.Exp3;

import java.util.Scanner;

// Add functionlity to calculate the total for each player and sort the players according to their average score

public class JaggedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        System.out.print("Enter number of players: ");
        int num = scanner.nextInt();

        int scores[][] = new int[num][];
        int matches[] = new int[num];
        float average[] = new float[num];
        int sum[] = new int [num];
        int sortOrder[] = new int[num];     // contains the index of the players in descending order of average score

        System.out.println("Enter the number of matches played by each player");

        for (int i = 0; i < num; i++)
        {
            matches [i] = scanner.nextInt();
            if (matches[i] > 0)
                scores [i] = new int [matches[i]];
            else 
                System.out.println ("Enter positive numbers only");
                continue;
        }

        for (int i = 0; i < num; i++)
        {
            System.out.println("\nEnter number of runs scored in the matches by player " + (i+1));
    
            for (int j = 0; j < matches[i]; j++)
            {
                scores [i][j] = scanner.nextInt();
                sum [i] += scores [i][j];
            }

            average[i] = ((float)sum [i]) / matches[i];
            // sortOrder[i] = i;
        }

        for (int i = 0; i < num; i++)
        {
            float min, prevmin = 0;
            float tempAvg[] = average;
            int minInd = i;
            min = tempAvg[i];

            for (int j = i; j < num; j++)
            {
                if (min > tempAvg[j])
                {
                    minInd = j;
                    min = tempAvg [j];
                }
            }

            sortOrder [i] = minInd;
            float temp = tempAvg[i];
            tempAvg [i] = tempAvg[minInd];
            tempAvg [minInd] = temp;
        }

        for (int i = 0; i < num; i++) 
        {
            int curInd = sortOrder [i];
            System.out.println("\nPlayer " + (curInd+1));

            for (int j = 0; j < matches[curInd]; j++) 
            {
                System.out.print(scores[curInd][j] + "  ");
            }
            System.out.println("\nAverage: " + average[curInd]);
            System.out.println("\nSum: " + sum[curInd]);
        }

        scanner.close();
    }
}
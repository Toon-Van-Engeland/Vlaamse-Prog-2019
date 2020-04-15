package Oefening3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int aantalTestCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i<=aantalTestCases; i++) {
            String rowCalls = scanner.nextLine();
            int[] breedteHoogte = new int[2];
            int counter = 0;
            for (String value : rowCalls.split(" ")){
                breedteHoogte[counter] = Integer.parseInt(value);
                counter++;
            }
            int[] sums = new int[breedteHoogte[0]];
            int[][] inputTable = new int[breedteHoogte[1]][breedteHoogte[0]];
            for(int j=0; j<breedteHoogte[1]; j++) {
                String getallen = scanner.nextLine();
                int c = 0;
                for (String value : getallen.split(" ")){
                    inputTable[j][c] = Integer.parseInt(value);
                    sums[c] += inputTable[j][c];
                    c++;
                }
            }
            for (int j=0; j<inputTable.length; j++) {
                System.out.print(i + " ");
                for(int k=0; k<inputTable[0].length; k++) {
                    System.out.printf("%" + lengteGetal(sums[k]) + "d", inputTable[j][k]);
                    if (k<inputTable[0].length -1) {
                        System.out.print(" | ");
                    }
                }
                System.out.println();
            }

            System.out.print(i + " ");
            for (int j=0; j<sums.length; j++){
                for(int k=0; k<lengteGetal(sums[j]); k++){
                    System.out.print("-");
                }
                if (j<sums.length-1) {
                    System.out.print("-+-");
                }
            }
            System.out.println();
            System.out.print(i + " ");
            for(int k=0; k<sums.length; k++) {
                System.out.printf("%" + lengteGetal(sums[k]) + "d", sums[k]);
                if (k<sums.length-1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();

        }
        scanner.close();
    }

    private static int lengteGetal(int input) {
        int output = 0;
        while (input>0){
            input = input / 10;
            output++;
        }
        return output;
    }
}

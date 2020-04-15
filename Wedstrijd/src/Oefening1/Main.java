package Oefening1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcases = scanner.nextInt();
        for(int z=1; z<=testcases; z++) {

        }
        int rekening = scanner.nextInt();
        int aantalDwergen = scanner.nextInt();
        int[] aantalDiamantenPerDwerg = new int[aantalDwergen];
        int[][] waardesDiamantenPerDwerg = new int[aantalDwergen][];
        int minimumAantalDiamanten = 20;
        for(int i=0; i<aantalDwergen; i++) {
            aantalDiamantenPerDwerg[i] = scanner.nextInt();
            if (aantalDiamantenPerDwerg[i] < minimumAantalDiamanten){
                minimumAantalDiamanten = aantalDiamantenPerDwerg[i];
            }
            waardesDiamantenPerDwerg[i] = new int[aantalDiamantenPerDwerg[i]];
            String input = scanner.nextLine();
            int counter = 0;
            for (String value : input.split(" ")){
                int tempwaarde = Integer.parseInt(value);
                if (tempwaarde < rekening){
                    waardesDiamantenPerDwerg[i][counter] = tempwaarde;
                    counter++;
                }
            }
            if (counter < minimumAantalDiamanten){
                minimumAantalDiamanten = counter;
            }
        }
        scanner.close();

        for(int k=1; k<=minimumAantalDiamanten; k++) {
            int tempRekening = rekening;
            int[][] positieArray = new int[k][k];
            for(int i = 0; i<k; k++) {
                for(int j = 0; j<k; j++) {
                    positieArray[i][j] = j;
                }
            }
            boolean uitvoer = naam(waardesDiamantenPerDwerg, tempRekening, 0, positieArray);
            if (uitvoer){
                System.out.println("Testnummer" + " " + k);
                break;
            }
        }
    }

    private static boolean naam(int[][] karaten, int totaal, int dwerg, int[][] karatenLocaties) {
        if (totaal == 0) {
            return true;
        }

        return false;
    }
}
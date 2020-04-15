package Oefening4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int aantalTestCases = scanner.nextInt();
        scanner.nextLine();
        for (int z = 1; z<=aantalTestCases; z++) {
            int breedte;
            int lengte;
            scanner.nextLine();
            String input = scanner.nextLine();
            breedte = Integer.parseInt(input.split(" ")[0]);
            lengte = Integer.parseInt(input.split(" ")[1]);
            int vlaggen = Integer.parseInt(input.split(" ")[2]);
            int[][] rooster = new int[breedte][lengte];
            for(int j=0; j<vlaggen; j++){
                String vlag = scanner.nextLine();
                int x = Integer.parseInt(input.split(" ")[0]);
                int y = Integer.parseInt(input.split(" ")[1]);
                int getal = Integer.parseInt(input.split(" ")[2]);
                rooster[x][y] = getal;
            }
            int paden = 0;
            for(int i=1; i<=lengte; i++) {
                paden = paden + paden*3;
            }
            Path[] paths = new Path[paden];
            for(int i=0; i<breedte; i++) {
                paths[i] = new Path();
            }
            for(int i=0; i<paden; i++) {
                paths[i].step();
            }
        }
        scanner.close();
    }

    static class Path {
        public int points;
        public boolean nodeFull;

        public Path(){
            nodeFull = false;
        }

        public void goLeft() {

        }
        public void goRight() {

        }
        public void goMid() {

        }

        public void step() {

        }

    }
}

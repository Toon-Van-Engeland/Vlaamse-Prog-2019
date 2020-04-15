import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> minima = new ArrayList<>();
        List<Integer> maxima = new ArrayList<>();
        int amountOfLists = scanner.nextInt();
        scanner.nextLine();
        for (int i=0; i<amountOfLists; i++){
            int lengthOfList = scanner.nextInt();
            scanner.nextLine();
            int maximum = 0;
            int minimum = 1000;
            for (int j=0; j<lengthOfList; j++){
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input < minimum) {
                    minimum = input;
                }
                if(input > maximum) {
                    maximum = input;
                }
            }
            minima.add(minimum);
            maxima.add(maximum);
        }

        for (int i=0; i<amountOfLists; i++){
            System.out.println(i+1 + " " + minima.get(i) + " " + maxima.get(i));
        }
    }
}

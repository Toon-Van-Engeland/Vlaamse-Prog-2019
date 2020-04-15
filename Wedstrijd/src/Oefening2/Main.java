package Oefening2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcases = scanner.nextInt();
        for(int z=1; z<=testcases; z++){
            int seconds = 0;
            long breedte = scanner.nextLong();
            Lemming[] lemmings = new Lemming[scanner.nextInt()];
            scanner.nextLine();
            for(int j=0; j<lemmings.length; j++) {
                String input = scanner.nextLine();
                lemmings[j] = new Lemming();
                if (input.charAt(input.length() - 1) == 'R') {
                    lemmings[j].goingRight = true;
                } else  {
                    lemmings[j].goingRight = false;
                }
                lemmings[j].pos = Integer.parseInt(input.substring(0, input.length()-1));
            }
            int amountLeftRoom = 0;
            while (amountLeftRoom != lemmings.length) {
                amountLeftRoom = 0;
                for(int i=0; i<lemmings.length; i++) {
                    if(lemmings[i].pos == breedte) {
                        lemmings[i].invertDirection();
                    }
                    lemmings[i].step();
                    seconds++;
                    if (lemmings[i].leftRoom) {
                        amountLeftRoom++;
                    }
                }
                for (int i=0; i<lemmings.length - 1; i++) {
                    for(int j = i+1; j<lemmings.length; j++){
                        if(lemmings[i].goingRight) {
                            if (lemmings[i].pos+1 == lemmings[j].pos && !lemmings[j].goingRight){
                                lemmings[i].invertDirection();
                                lemmings[j].invertDirection();
                                lemmings[i].stepper = false;
                                lemmings[j].stepper = false;
                            }
                        } else {
                            if (lemmings[i].pos-1 == lemmings[j].pos && lemmings[j].goingRight){
                                lemmings[i].invertDirection();
                                lemmings[j].invertDirection();
                                lemmings[i].stepper = false;
                                lemmings[j].stepper = false;
                            }
                        }
                        if(lemmings[i].pos == lemmings[j].pos){
                            lemmings[i].invertDirection();
                            lemmings[j].invertDirection();
                        }
                    }
                }
            }
            System.out.println(z + " " + seconds / 2);

        }
        scanner.close();
    }

    static class Lemming{
        public int pos;
        public boolean goingRight;
        public boolean leftRoom;
        public boolean stepper;

        public Lemming() {
            leftRoom = false;
            stepper = true;
        }

        public void invertDirection(){
            if(goingRight){
                goingRight = false;
            } else {
                goingRight = true;
            }
        }

        public void step() {
            if (stepper || !leftRoom) {
                if(goingRight){
                    pos++;
                } else {
                    pos--;
                }
                if (pos <= 0) {
                    leftRoom = true;
                }
            } else {
                stepper = true;
            }
        }
    }
}
/*
3
6
2
2R
4L
100
2
10L
80R
100
2
40R
60L
*/
public class PreparatieLennert {
    public static final int[] NOTHING_FOUND_ARRAY = {-1, -1, -1, -1};

    public static void main(String[] args) {
        char[][] woordseeker={  {'m','o','l','a','m'},
                                {'w','e','a','z','b'},
                                {'t','t','w','r','w'},
                                {'u','x','i','e','r'}};
        String[] results = {"mew","ekans","uxie","natu"};

        for(String result:results){
            System.out.print(result + ": ");
            System.out.println(findWord(result,woordseeker));
        }
    }

    public static int[] loopInOneDirection(int startedLoops,int startX, int startY, int x, int y,
                                           int xMovement, int yMovement, String  word, char[][] wordseeker) {
        if (startedLoops == word.length()) { //entire word found
            int[] found = {startX, startY, xMovement, yMovement};
            return found;
        }
        yMovement = startY + y * startedLoops;//yEnd at the end
        xMovement = startX + x * startedLoops;//xEnd at the end

        if (startedLoops == word.length()) { //entire word found
            int[] found = {startX, startY, xMovement, yMovement};
            return found;
        }
        if(yMovement >= 0 && xMovement >= 0  &&
                yMovement<wordseeker.length && xMovement < wordseeker[yMovement].length) {
            if(wordseeker[yMovement][xMovement] == word.charAt(startedLoops)){//x and Y may be swapped here idk
                return loopInOneDirection((startedLoops+1), startX, startY, x, y, xMovement, yMovement, word, wordseeker);
            }
        }
        return NOTHING_FOUND_ARRAY;
    }

    public static int[] findTail( String word, char[][] wordseeker, int startY, int startX){
        int[] directionalArray = {-1, 0, 1};
        int yMovement;
        int xMovement;
        int[] result;

        for (int x : directionalArray) {
            for (int y : directionalArray){
                if (x != 0 || y != 0){
                    yMovement = startY + y;
                    xMovement = startX + x;
                    if(yMovement >= 0 && xMovement >= 0  &&
                            yMovement<wordseeker.length && xMovement < wordseeker[yMovement].length) {
                        result = loopInOneDirection(1, startX, startY, x, y, 0,0, word, wordseeker);
                        if (result != NOTHING_FOUND_ARRAY){return result;}
                    }
                }
            }
        }
        return NOTHING_FOUND_ARRAY;
    }

    public static String findWord(String word, char[][] wordSeeker){
        int[] result = new int[4];
        char firstLetter = word.charAt(0);
        for( int row = 0; row <wordSeeker.length; row++){
            for (int coll = 0; coll<wordSeeker[row].length; coll++ ){
                if(firstLetter == wordSeeker[row][coll]){
                    result = findTail(word,wordSeeker,row,coll);
                    if (result != NOTHING_FOUND_ARRAY){
                        return "" + word + " starts at (" + (result[0]+1) + ", " + (result[1]+1) + ") and ends at ("
                                + (result[2]+1) + ", " + (result[3]+1) + ").";
                    }
                }
            }
        }
        return "" + word + " not found!";

    }
}

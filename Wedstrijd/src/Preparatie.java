import java.util.ArrayList;
import java.util.List;

public class Preparatie {
    public static void main(String[] args) {
        double[][] voorbeeldMatrix = {{0.0 , 0.1 , 0.2 , 0.3 , 0.4 , 0.5} ,
                                      {1.0 , 1.1 , 1.2 , 1.3 , 1.4 , 1.5} ,
                                      {2.0 , 2.1 , 2.2 , 2.3 , 2.4 , 2.5} ,
                                      {3.0 , 3.1 , 3.2 , 3.3 , 3.4 , 3.5} ,
                                      {4.0 , 4.1 , 4.2 , 4.3 , 4.4 , 4.5} ,
                                      {5.0 , 5.1 , 5.2 , 5.3 , 5.4 , 5.5}};
        List<List<Double>> listMatrix = new ArrayList<>();

        String output = "";
        for (int i=0; i<6; i++) {
            listMatrix.add(new ArrayList<Double>());
            for (int j=0; j<6; j++) {
                output = output + voorbeeldMatrix[i][j] + " ";
                listMatrix.get(i).add(voorbeeldMatrix[i][j]);
            }
            output = output + "\n";
        }

        System.out.println(output);
        for (Double ding : directeBurenMetDiagonaleBuren(voorbeeldMatrix, 0, 2)) {
            System.out.print(ding + " ");
        }
        System.out.println();
        for (Double ding : directeBuren(voorbeeldMatrix, 5, 1)) {
            System.out.print(ding + " ");
        }
        System.out.println();
        for (Double ding : directeBurenMetDiagonaleBurenWrapAround(voorbeeldMatrix, 0, 2)) {
            System.out.print(ding + " ");
        }
        System.out.println();
        for (Double ding : directeBurenWrapAround(voorbeeldMatrix, 0, 2)) {
            System.out.print(ding + " ");
        }
        System.out.println();
        System.out.println("--------------------------");
        System.out.println();
        List<Double> doubleList = burenVanBurenWrapAround(listMatrix, 3, 3);
        doubleList.sort(Double::compareTo);
        for(Double ding : doubleList){
            System.out.print(ding + " ");
        }
        System.out.println();
        System.out.println(doubleList.size());
    }

    private static List<Double> directeBurenMetDiagonaleBuren(double[][] input, int rowLocation, int columnLocation) {
        List<Double> output = new ArrayList<>();
        int rowLength = input[1].length;
        int columnLength = input.length;
        for (int i = rowLocation - 1; i<=rowLocation + 1; i++) {
            if (i >= 0 && i < rowLength) {
                for (int j = columnLocation - 1; j<=columnLocation + 1; j++) {
                    if (!(i == rowLocation && j==columnLocation) && j >= 0 && j < columnLength) {
                        output.add(input[i][j]);
                    }
                }
            }
        }

        return output;
    }

    private static List<Double> directeBuren(double[][] input, int rowLocation, int columnLocation) {
        List<Double> output = new ArrayList<>();
        int rowLength = input[1].length;
        int columnLength = input.length;
        int i = rowLocation - 1;
        int j = columnLocation;
        if (i >= 0 && j >= 0 && i < rowLength && j < columnLength) {
            output.add(input[i][j]);
        }
        i = rowLocation;
        j = columnLocation - 1;
        if (i >= 0 && j >= 0 && i < rowLength && j < columnLength) {
            output.add(input[i][j]);
        }
        i = rowLocation;
        j = columnLocation + 1;
        if (i >= 0 && j >= 0 && i < rowLength && j < columnLength) {
            output.add(input[i][j]);
        }
        i = rowLocation + 1;
        j = columnLocation;
        if (i >= 0 && j >= 0 && i < rowLength && j < columnLength) {
            output.add(input[i][j]);
        }

        return output;
    }

    private static List<Double> directeBurenMetDiagonaleBurenWrapAround(double[][] input, int rowLocation, int columnLocation) {
        List<Double> output = new ArrayList<>();
        int rowLength = input[1].length;
        int columnLength = input.length;
        for (int i = rowLocation - 1; i<=rowLocation + 1; i++) {
            for (int j = columnLocation - 1; j<=columnLocation + 1; j++) {
                if (!(i == rowLocation && j==columnLocation) && j >= 0) {
                    int iIndex = (i + rowLength) % rowLength;
                    int jIndex = (j + columnLength) % columnLength;
                    output.add(input[iIndex][jIndex]);
                }
            }
        }

        return output;
    }

    private static List<Double> directeBurenWrapAround(double[][] input, int rowLocation, int columnLocation) {
        List<Double> output = new ArrayList<>();
        int rowLength = input[1].length;
        int columnLength = input.length;

        int i = (rowLocation - 1 + rowLength) % rowLength;
        int j = (columnLocation + columnLength) % columnLength;
        if (i >= 0 && j >= 0) {
            output.add(input[i][j]);
        }
        i = (rowLocation + rowLength) % rowLength;
        j = (columnLocation - 1 + columnLength) % columnLength;
        if (i >= 0 && j >= 0) {
            output.add(input[i][j]);
        }
        i = (rowLocation + rowLength) % rowLength;
        j = (columnLocation + 1 + columnLength) % columnLength;
        if (i >= 0 && j >= 0) {
            output.add(input[i][j]);
        }
        i = (rowLocation + 1 + rowLength) % rowLength;
        j = (columnLocation + columnLength) % columnLength;
        if (i >= 0 && j >= 0) {
            output.add(input[i][j]);
        }

        return output;
    }

    private static List<Double> burenVanBurenWrapAround(List<List<Double>> input, int rowLocation, int columnLocation) {
        List<Double> output = new ArrayList<>();
        int rowLength = input.get(0).size();
        int columnLength = input.size();
        for (int i = rowLocation - 1; i<=rowLocation + 1; i++) {
            for (int j = columnLocation - 1; j<=columnLocation + 1; j++) {
                if (!(i == rowLocation && j==columnLocation) && j >= 0) {
                    int iIndex = (i + rowLength) % rowLength;
                    int jIndex = (j + columnLength) % columnLength;
                    List<Double> burenVanDeBuur = directeBurenMetDiagonaleBurenWrapAround(input, iIndex, jIndex);
                    for (Double buurVanBuur : burenVanDeBuur) {
                        if (!output.contains(buurVanBuur)) {
                            output.add(buurVanBuur);
                        }
                    }
                }
            }
        }
        return output;
    }

    private static List<Double> directeBurenMetDiagonaleBurenWrapAround(List<List<Double>> input, int rowLocation, int columnLocation) {
        List<Double> output = new ArrayList<>();
        int rowLength = input.get(0).size();
        int columnLength = input.size();
        for (int i = rowLocation - 1; i<=rowLocation + 1; i++) {
            for (int j = columnLocation - 1; j<=columnLocation + 1; j++) {
                if (!(i == rowLocation && j==columnLocation) && j >= 0) {
                    int iIndex = (i + rowLength) % rowLength;
                    int jIndex = (j + columnLength) % columnLength;
                    output.add(input.get(iIndex).get(jIndex));
                }
            }
        }

        return output;
    }
}

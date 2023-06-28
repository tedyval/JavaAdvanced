package FormulaOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int sizeMatr = Integer.parseInt(scanner.nextLine());
        int countCommand = Integer.parseInt(scanner.nextLine());
        int rowPlayer = -1;
        int colPlayer = -1;
        List<int[][]> positions = new ArrayList<>();
        char[][] matrix = new char[sizeMatr][sizeMatr];
        for (int i = 0; i < matrix.length; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.replaceAll(" ", "").toCharArray();
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'P') {
                    rowPlayer = i;
                    colPlayer = j;
                    break;
                }

            }

        }

        int[][] lastPosition = new int[rowPlayer][colPlayer];
        positions.add(lastPosition);
        boolean isWon = false;
        while (countCommand > 0) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    rowPlayer--;
                    if (!isInMatrix(sizeMatr, rowPlayer, colPlayer)) {
                        rowPlayer = sizeMatr - 1;
                        lastPosition = new int[rowPlayer][colPlayer];
                        positions.add(lastPosition);
                        break;
                    }

                    if (matrix[rowPlayer][colPlayer] == 'F') {
                        lastPosition = new int[rowPlayer][colPlayer];
                        positions.add(lastPosition);
                        isWon = true;
                        break;
                    } else if (matrix[rowPlayer][colPlayer] == 'B') {
                        rowPlayer--;
                        if (!isInMatrix(sizeMatr, rowPlayer, colPlayer)) {
                            rowPlayer = sizeMatr - 1;
                            lastPosition = new int[rowPlayer][colPlayer];
                            positions.add(lastPosition);
                            break;
                        } else {
                            lastPosition = new int[rowPlayer][colPlayer];
                            positions.add(lastPosition);
                        }
                    } else if (matrix[rowPlayer][colPlayer] == 'T') {

                        lastPosition = positions.get(positions.size() - 1);
                        rowPlayer = lastPosition.length;
                    } else {
                        lastPosition = new int[rowPlayer][colPlayer];
                        positions.add(lastPosition);
                    }

                    break;
                case "down":
                    rowPlayer++;
                    if (!isInMatrix(sizeMatr, rowPlayer, colPlayer)) {
                        rowPlayer = 0;
                        lastPosition = new int[rowPlayer][colPlayer];
                        positions.add(lastPosition);
                        break;
                    }

                    if (matrix[rowPlayer][colPlayer] == 'F') {
                        lastPosition = new int[rowPlayer][colPlayer];
                        positions.add(lastPosition);
                        isWon = true;
                        break;
                    } else if (matrix[rowPlayer][colPlayer] == 'B') {
                        rowPlayer++;
                        if (!isInMatrix(sizeMatr, rowPlayer, colPlayer)) {
                            rowPlayer = 0;
                            lastPosition = new int[rowPlayer][colPlayer];
                            positions.add(lastPosition);
                            break;
                        } else {
                            lastPosition = new int[rowPlayer][colPlayer];
                            positions.add(lastPosition);
                        }
                    } else if (matrix[rowPlayer][colPlayer] == 'T') {

                        lastPosition = positions.get(positions.size() - 1);
                        rowPlayer = lastPosition.length;
                    } else {
                        lastPosition = new int[rowPlayer][colPlayer];
                        positions.add(lastPosition);
                    }

                    break;
                case "left":
                    colPlayer--;
                    if (!isInMatrix(sizeMatr, rowPlayer, colPlayer)) {
                        colPlayer = sizeMatr - 1;
                        lastPosition = new int[rowPlayer][colPlayer];
                        positions.add(lastPosition);
                        break;
                    }

                    if (matrix[rowPlayer][colPlayer] == 'F') {
                        lastPosition = new int[rowPlayer][colPlayer];
                        positions.add(lastPosition);
                        isWon = true;
                        break;
                    } else if (matrix[rowPlayer][colPlayer] == 'B') {
                        colPlayer--;
                        if (!isInMatrix(sizeMatr, rowPlayer, colPlayer)) {
                            colPlayer = sizeMatr - 1;
                            lastPosition = new int[rowPlayer][colPlayer];
                            positions.add(lastPosition);
                            break;
                        } else {
                            lastPosition = new int[rowPlayer][colPlayer];
                            positions.add(lastPosition);
                        }
                    } else if (matrix[rowPlayer][colPlayer] == 'T') {

                        lastPosition = positions.get(positions.size() - 1);
                        colPlayer = lastPosition[lastPosition.length - 1].length;
                    } else {
                        lastPosition = new int[rowPlayer][colPlayer];
                        positions.add(lastPosition);
                    }

                    break;
                case "right":
                    colPlayer++;
                    if (!isInMatrix(sizeMatr, rowPlayer, colPlayer)) {
                        colPlayer = 0;
                        lastPosition = new int[rowPlayer][colPlayer];
                        positions.add(lastPosition);
                        break;
                    }

                    if (matrix[rowPlayer][colPlayer] == 'F') {
                        lastPosition = new int[rowPlayer][colPlayer];
                        positions.add(lastPosition);
                        isWon = true;
                        break;
                    } else if (matrix[rowPlayer][colPlayer] == 'B') {
                        colPlayer++;
                        if (!isInMatrix(sizeMatr, rowPlayer, colPlayer)) {
                            colPlayer = 0;
                            lastPosition = new int[rowPlayer][colPlayer];
                            positions.add(lastPosition);
                            break;
                        } else {
                            lastPosition = new int[rowPlayer][colPlayer];
                            positions.add(lastPosition);
                        }
                    } else if (matrix[rowPlayer][colPlayer] == 'T') {

                        lastPosition = positions.get(positions.size() - 1);
                        colPlayer = lastPosition[lastPosition.length - 1].length;
                    } else {
                        lastPosition = new int[rowPlayer][colPlayer];
                        positions.add(lastPosition);
                    }


                    break;

            }

            if (isWon == true) {
                break;
            }
            countCommand--;
        }


        if (isWon == true) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        print(positions, matrix);


    }

    private static void print(List<int[][]> positions, char[][] matrix) {
        int[][] positPAtStart = positions.get(0);
        int row = positPAtStart.length;
        int col = positPAtStart[positPAtStart.length - 1].length;
        matrix[row][col] = '.';
        int[][] positPAtEnd = positions.get(positions.size() - 1);
        matrix[positPAtEnd.length][positPAtEnd[positPAtEnd.length - 1].length] = 'P';


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }

            System.out.println();
        }
    }

    private static boolean isInMatrix(int marixSize, int rowPlayer, int colPlayer) {
        return rowPlayer >= 0 && rowPlayer < marixSize  && colPlayer >= 0 && colPlayer < marixSize ;
    }
}

package MultidimensionalArrayExercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rotationType = scanner.nextLine();
        String inputLine = scanner.nextLine();
        int counter = 0;
        List<String> lines = new ArrayList<>();
        ArrayDeque<Integer> lengts = new ArrayDeque<>();

        while (!inputLine.equals("END")) {
            counter++;
            int length = inputLine.length();
            lines.add(inputLine);
            lengts.push(length);
            inputLine = scanner.nextLine();
        }

        int maxLength = Collections.max(lengts);
        String[][] matrix = new String[counter][maxLength];
        for (int i = 0; i < counter; i++) {
            matrix[i] = lines.get(i).split("");
        }


        String expression = "(?<text>Rotate)\\((?<degree>\\d+)\\)";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(rotationType);
        int degree = 0;
        while (matcher.find()) {
            degree = Integer.parseInt(matcher.group("degree"));
        }


        while (degree > 360) {
            degree -= 360;

        }


        switch (degree) {
            case 0:
            case 360:
               printMatrix(matrix);
                break;
            case 90:
                List<String> lineAsArray = new ArrayList<>();
                String[][] output = new String[maxLength][counter];
                for (int i = 0; i < matrix.length; ) {

                    lineAsArray = new ArrayList<>(Arrays.asList(matrix[i]));

                    for (int k = counter-1; k >= 0; ) {
                        for (int j = 0; j < maxLength; ) {
                            for (int l = 0; l < lineAsArray.size(); ) {
                                lineAsArray = new ArrayList<>(Arrays.asList(matrix[i]));
                                output[j][k] = lineAsArray.get(l);
                                j++;
                                l++;
                                if (l == lineAsArray.size()) {
                                    i++;
                                    if (i == matrix.length) {
                                        break;
                                    } else {
                                        lineAsArray.clear();
                                        lineAsArray = new ArrayList<>(Arrays.asList(matrix[i]));
                                    }

                                    j = 0;
                                    k--;
                                    l = 0;
                                }
                            }
                            if (i == matrix.length) {
                                break;
                            }

                        }
                        if (i == matrix.length) {
                            break;
                        }
                    }
                    if (i == matrix.length) {
                        break;
                    }
                }


                printMatrix(output);


                break;
            case 180:
                lineAsArray = new ArrayList<>();
                output = new String[counter][maxLength];
                for (int i = 0; i < matrix.length; ) {

                    lineAsArray = new ArrayList<>(Arrays.asList(matrix[i]));

                    for (int j = counter-1; j >=0 ; ) {
                        for (int k =maxLength - 1; k >= 0; ) {
                            for (int l = 0; l < lineAsArray.size() ; ) {
                                lineAsArray = new ArrayList<>(Arrays.asList(matrix[i]));
                                output[j][k] = lineAsArray.get(l);
                                k--;
                                l++;
                                if (l == lineAsArray.size() ){
                                    i++;
                                    if (i == matrix.length) {
                                        break;
                                    } else {
                                        lineAsArray.clear();
                                        lineAsArray = new ArrayList<>(Arrays.asList(matrix[i]));
                                    }

                                    j --;
                                    k = maxLength - 1;
                                    l = 0;
                                }
                            }
                            if (i == matrix.length) {
                                break;
                            }

                        }
                        if (i == matrix.length) {
                            break;
                        }
                    }
                    if (i == matrix.length) {
                        break;
                    }
                }


                printMatrix(output);



                break;
            case 270:
                 lineAsArray = new ArrayList<>();
                output = new String[maxLength][counter];
                for (int i = 0; i < matrix.length; ) {

                    lineAsArray = new ArrayList<>(Arrays.asList(matrix[i]));

                    for (int k = 0; k < counter; ) {
                        for (int j = maxLength - 1; j >= 0; ) {
                            for (int l = 0; l < lineAsArray.size(); ) {
                                lineAsArray = new ArrayList<>(Arrays.asList(matrix[i]));
                                output[j][k] = lineAsArray.get(l);
                                j--;
                                l++;
                                if (l == lineAsArray.size()) {
                                    i++;
                                    if (i == matrix.length) {
                                        break;
                                    } else {
                                        lineAsArray.clear();
                                        lineAsArray = new ArrayList<>(Arrays.asList(matrix[i]));
                                    }

                                    j = maxLength - 1;
                                    k++;
                                    l = 0;
                                }
                            }
                            if (i == matrix.length) {
                                break;
                            }

                        }
                        if (i == matrix.length) {
                            break;
                        }
                    }
                    if (i == matrix.length) {
                        break;
                    }
                }


                printMatrix(output);



                break;

        }


    }

    private static void printMatrix(String[][] output) {
        for (String[] strings : output) {
            for (String string : strings) {
                if(string != null){
                    System.out.print(string);
                }else{
                    System.out.print(" ");
                }

            }
            System.out.println();

        }
    }
}

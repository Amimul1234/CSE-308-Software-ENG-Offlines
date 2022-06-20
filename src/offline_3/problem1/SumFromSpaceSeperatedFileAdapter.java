package offline_3.problem1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SumFromSpaceSeperatedFileAdapter implements CalculateSum {

    private final SumFromSpaceSeperatedFile sumFromSpaceSeperatedFile;

    public SumFromSpaceSeperatedFileAdapter() {
        this.sumFromSpaceSeperatedFile = new SumFromSpaceSeperatedFile();
    }

    @Override
    public int calculateSum( String filename ) {
        processCurlSeperatedFile(filename);
        return sumFromSpaceSeperatedFile.calculateSum("src/offline_3/problem1/spaceSeperatedFile.txt");
    }

    private void processCurlSeperatedFile( String filename ) {

        Scanner scanner;
        List<String> numberList = new ArrayList<>();

        try {
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Given file name not found");
            return;
        }

        while (scanner.hasNextLine()) {
            String[] strings = scanner.nextLine().split("~");
            numberList.addAll(Arrays.asList(strings));
        }

        scanner.close();

        PrintWriter writer;

        try {
            writer = new PrintWriter(new FileWriter("src/offline_3/problem1/spaceSeperatedFile.txt"));

            for (String s : numberList) {
                writer.write(s);
                writer.write(' ');
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Filename not found");
        }
    }

}

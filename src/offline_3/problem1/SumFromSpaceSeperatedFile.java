package offline_3.problem1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SumFromSpaceSeperatedFile implements CalculateSum {

    public int calculateSum( String filename ) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            int sum = 0;
            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                sum += number;
            }
            return sum;
        } catch (FileNotFoundException e) {
            System.out.println("File with given name not found!");
            return -1;
        }
    }

}

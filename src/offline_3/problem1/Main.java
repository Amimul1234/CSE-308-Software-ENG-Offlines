package offline_3.problem1;

public class Main {
    public static void main( String[] args ) {
        CalculateSum sum = new SumFromSpaceSeperatedFileAdapter();
        System.out.println(sum.calculateSum("src/offline_3/problem1/curlSeperatedFile"));
    }
}

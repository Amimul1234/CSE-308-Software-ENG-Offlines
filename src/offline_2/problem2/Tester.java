package offline_2.problem2;

import offline_2.problem2.editor.Editor;

import java.util.Scanner;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class Tester {

    public static void main( String[] args ) {

        Editor editor = Editor.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("Please input filename with extension (type exit for exit) : ");

            String s = scanner.nextLine();

            if (s.equalsIgnoreCase("exit"))
                System.exit(0);

            editor.openFileInEditor(s);
        }

    }

}

package offline_2.problem2.editor;

import offline_2.problem2.parser.Parser;
import offline_2.problem2.parser.impl.CParser;
import offline_2.problem2.parser.impl.CppParser;
import offline_2.problem2.parser.impl.PyParser;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class Editor {

    private static Editor editor;

    private Editor() {

    }

    public static Editor getInstance() {
        if (editor == null)
            editor = new Editor();

        return editor;
    }

    public void openFileInEditor( String fileName ) {

        Parser parser;

        if (fileName.endsWith(".c"))
            parser = new CParser();
        else if (fileName.endsWith(".cpp"))
            parser = new CppParser();
        else if (fileName.endsWith(".py"))
            parser = new PyParser();
        else {
            System.out.println("Invalid file type given");
            return;
        }

        System.out.println(parser.getFont().toString() + " ," + parser);

    }
}

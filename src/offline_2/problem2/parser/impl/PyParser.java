package offline_2.problem2.parser.impl;

import offline_2.problem2.font.Font;
import offline_2.problem2.font.impl.ConsolasFont;
import offline_2.problem2.parser.Parser;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class PyParser implements Parser {

    @Override
    public Font getFont() {
        return new ConsolasFont();
    }

    @Override
    public String toString() {
        return "Environment is python, Parser is Python parser";
    }
}

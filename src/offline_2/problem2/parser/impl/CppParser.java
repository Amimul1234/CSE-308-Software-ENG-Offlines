package offline_2.problem2.parser.impl;

import offline_2.problem2.font.Font;
import offline_2.problem2.font.impl.MonacoFont;
import offline_2.problem2.parser.Parser;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class CppParser implements Parser {
    @Override
    public Font getFont() {
        return new MonacoFont();
    }

    @Override
    public String toString() {
        return "Environment is CPP, Parser is CPP parser";
    }
}

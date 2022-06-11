package offline_2.problem2.parser.impl;

import offline_2.problem2.font.Font;
import offline_2.problem2.font.impl.CourierNewFont;
import offline_2.problem2.parser.Parser;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class CParser implements Parser {

    @Override
    public Font getFont() {
        return new CourierNewFont();
    }

    @Override
    public String toString() {
        return "Environment is C, Parser is C parser";
    }
}

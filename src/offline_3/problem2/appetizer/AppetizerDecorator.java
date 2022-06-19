package offline_3.problem2.appetizer;

import offline_3.problem2.burger.Burger;

public abstract class AppetizerDecorator implements Burger {
    @Override
    public String getDescription() {
        return "Appetizer";
    }
}

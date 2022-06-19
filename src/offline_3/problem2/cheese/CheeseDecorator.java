package offline_3.problem2.cheese;

import offline_3.problem2.burger.Burger;

public abstract class CheeseDecorator implements Burger {
    @Override
    public String getDescription() {
        return "Cheese";
    }
}
